package grid;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JPanel;

import jeu.MenuJeu;
import jeu.Score_de_niveau;
import main.MainClass;
import sons.AudioFile;
import sons.AudioWav;
import t2s.SIVOXDevint;
import elements.Element;
import elements.ImageLoad;
import elements.Kirby;
import elements.Luffy;
import elements.MariaV3;
import elements.Spacy;
import elements.Nook;
import elements.Personnage;

/**
 * Map implémente Runnable et construit un niveau de jeu. .
 * @author Leviathor
 */

public class Map extends JPanel implements KeyListener, Runnable{

	private Grid grille;
	private String path_map;
	private Personnage maria;
	public Robot robot;
	public boolean cantMove;
	public boolean cantReturnLeft;
	public boolean cantReturnRight;
	public String path;
	public int niveauInit;
	private Graphics2D g2d;
	private SIVOXDevint voix;
	public boolean quit;
	private boolean first = true;

	/**
	 * Le constructeur de la classe .
	 * Il prend en paramètrele chemin du fihcier texte contenant les infos de la map .
	 * @param path_txt
	 */
	public Map(int niveauInit, ImageLoad imageLoad) {
		super();
		this.quit = true;
		voix = new SIVOXDevint();
		MainClass.ratioHeight = (double)MainClass.screenHeight/900;
		MainClass.ratioWidth = (double)MainClass.screenWidth/1600;
		
		if(MainClass.affichage==Affichage.ROSE) this.setBackground(new Color(8,67,107));
		else if(MainClass.affichage==Affichage.SIMPLE) this.setBackground(new Color(255,255,255));
		else if(MainClass.affichage==Affichage.INVERSE) this.setBackground(new Color(8,67,107));
		else this.setBackground(new Color(0,113,188));

		this.setSize(900, 1600);
		this.niveauInit=niveauInit;
		this.grille = new Grid(MainClass.file, MainClass.imageLoad);
		this.initLevel(grille.initX.get(niveauInit-1),grille.initY.get(niveauInit-1));
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		this.cantMove=false;
		this.cantReturnLeft=false;
		this.cantReturnRight=false;
		MainClass.score_actuel = new Score_de_niveau();
	}

	//1 : maria
	//2 : mario
	//3 : nook
	//4 : kirby
	private void initLevel(int x, int y) {
		switch(MainClass.perso){
		case 1 :
			maria = new MariaV3(x, y,this);
			break;
		case 2 :
			maria = new Spacy(x,y,this);
			break;
		case 3 :
			maria = new Nook(x,y,this);
			break;
		case 4 :
			maria = new Luffy(x,y,this);
			break;
		case 5 :
			maria = new Kirby(x,y,this);
			break;

		default :
			maria = new MariaV3(x, y,this);
			break;
		}
		new Thread(this).start();
		maria.initImages();
	}
	
	private void music(int niveau){
		switch(niveau%4){
		case 0 :
			AudioWav.playSound(AudioFile.LEVEL1);
			break;
		case 1 :
			AudioWav.playSound(AudioFile.LEVEL2);
			break;
		case 2 :
			AudioWav.playSound(AudioFile.LEVEL3);
			break;
		case 3 :
			AudioWav.playSound(AudioFile.LEVEL4);
			break;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		g2d.drawImage(maria.getImageCourante(),maria.getCenterX(), maria.getCenterY(),MariaV3.persoWidth,MariaV3.persoHeight, this);
		grille.draw(g2d);
	}

	@Override
	public void run() {
		while (quit) {
			if(first){
				if(niveauInit == 13){
					try{
						voix.playText("Attention, le sol peu parfois nous réserver des surprises !");
						Thread.sleep(3000);
					} catch(Exception e){
						e.printStackTrace();
					}
				}
				if(niveauInit == 14){
					try{
						voix.playText("Saperlipopette, le dessinateur a oublié de dessiné le sol ! Saura tu trouver ton chemin ?");
						Thread.sleep(4500);
					} catch(Exception e){
						e.printStackTrace();
					}
				}
				music(niveauInit++);
				first = false;
			}
			maria.update();
			repaint();
			try {
				Thread.sleep((MainClass.ratioWidth <= 0.5)?1:2);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	public void changeColor(){
		if(MainClass.affichage==Affichage.BLEU){
			MainClass.affichage=Affichage.ROSE;
			this.setBackground(new Color(8,67,107));
		}
		else if(MainClass.affichage==Affichage.ROSE){
			MainClass.affichage=Affichage.SIMPLE;
			this.setBackground(new Color(255,255,255));
		}
		else if(MainClass.affichage==Affichage.SIMPLE){
			MainClass.affichage=Affichage.INVERSE;
			this.setBackground(new Color(8,67,107));
		}else{
			MainClass.affichage=Affichage.BLEU;
			this.setBackground(new Color(0,113,188));
		}
		
		MainClass.imageLoad = new ImageLoad();
		this.grille = new Grid(MainClass.file, MainClass.imageLoad);		
	}

	@Override
	public void keyPressed(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_SPACE :
			maria.sortieTuyau();
			break;
		case KeyEvent.VK_ENTER:
			AudioWav.stop();
			MainClass.resetLevel(--niveauInit);
			voix.stop();
			break;
		case KeyEvent.VK_F3:
			changeColor();
			break;
		case KeyEvent.VK_LEFT:
			if(!cantMove && !cantReturnRight && !maria.isAnAction()){
				maria.actionGauche();
				this.robot.keyRelease(KeyEvent.VK_LEFT);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(!cantMove && !cantReturnLeft && !maria.isAnAction()){
				maria.actionDroite();
				this.robot.keyRelease(KeyEvent.VK_RIGHT);
			}
			break;
		case KeyEvent.VK_DOWN:
			if(!cantMove && !maria.isAnAction()) maria.actionBas();
			break;
		case KeyEvent.VK_UP:
			if(!cantMove && !maria.isAnAction()) maria.actionHaut();
			break;
		case KeyEvent.VK_ESCAPE:
			this.quit = false;
			MainClass.gestionScore.ecritureScoreNull();
	        new jeu.MenuJeu("Maria Brosse & Co.");
	        AudioWav.stop();
			voix.stop();
			break;
		case KeyEvent.VK_F1:
			voix.stop();
			AudioWav.stop();
			voix.playText("Essaie d'atindr le tuyau avec une flèche ! Si tu è coinssé, appui sur ENTRER pour recommencer le niveau ! ");
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			music(niveauInit-1);
			break;
			
		case KeyEvent.VK_F4:
			voix.stop();
			AudioWav.stop();
			voix.playText("Maria et ses ami veulent devenir plombié . Aide lè à accomplir leur rêve en cherchant ton chemin"
					+ "dan le labirinte de tuiyo !");
			try {
				Thread.sleep(6500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			music(niveauInit-1);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if(cantReturnRight) cantReturnRight=false;
			maria.stopGauche();
			break;
		case KeyEvent.VK_RIGHT:
			if(cantReturnLeft) cantReturnLeft=false;
			maria.stopDroit();
			break;
		}
	}

	public Personnage getMaria() {
		return maria;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public Grid getGrille() {
		return grille;
	}

	public String getPath_map() {
		return path_map;
	}

}
