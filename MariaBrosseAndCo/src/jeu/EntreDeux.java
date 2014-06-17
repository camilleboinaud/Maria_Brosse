package jeu;

import grid.Affichage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import sons.AudioFile;
import sons.AudioWav;
import main.MainClass;
import devintAPI.FenetreAbstraite;

public class EntreDeux extends FenetreAbstraite{
	private Panel panel;
	private int niveau;
	private AudioWav audio;
	private boolean canQuit = false;
	
	
	public EntreDeux(int niveau) {
		super("Bravo !");
		this.setCursor(this.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), null));
		this.niveau=niveau-1;
		this.audio = new AudioWav();
		Panel panel =  new Panel(this.niveau);
		this.add(panel);
		this.setVisible(true);
		AudioWav.playSound(AudioFile.FINAL);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		canQuit = true;
		if(MainClass.frame!=null) MainClass.frame.dispose();
		MainClass.frame = this;
	}

	@Override
	protected void init() {
	}

	@Override
	protected String wavAide() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String wavAccueil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String wavRegleJeu() {
		// TODO Auto-generated method stub
		return null;
	}

	public void keyPressed(KeyEvent key) {
		if(canQuit){
			switch(key.getKeyCode()){
				case KeyEvent.VK_F4:
					voix.stop();
					AudioWav.stop();
					voix.playText("Maria et ses ami veulent devenir plombié . Aide lè à accomplir leur rêve en cherchant ton chemin"
							+ "dan le labirinte de tuiyo !");
					break;
				case KeyEvent.VK_F1:
					voix.stop();
					AudioWav.stop();
					voix.playText("Bravo ! Tu as terminé le nivo "+this.niveau+" ! Tu a maintenant "+MainClass.scoreActuel+" points d'expérience !"
							+ "Appuie sur une touche du clavié pour passé au nivo suivant.");
					break;
				case KeyEvent.VK_ESCAPE:
					MainClass.gestionScore.ecritureScoreNull();
			        new jeu.MenuJeu("Maria Brosse & Co.");
			        AudioWav.stop();
					voix.stop();
					break;
				case KeyEvent.VK_F3:
					voix.stop();
					AudioWav.stop();
					voix.playText("Désolé, tu ne peu pa changé lè couleur maintenant. Appuie sur la touche F 1 si tu veu entendre ton score.");
					break;
				default:
					AudioWav.stop();
					MainClass.resetLevel(++MainClass.niveauInit);
					voix.stop();
					break;
			}
		}
	}
	

	private class Panel extends JPanel{
		private Jauge jauge;
		private Score_de_niveau score;
		private int niveau;

		public Panel(int niveau) {
			this.jauge = new Jauge();
			this.niveau = niveau;
			init();
		}
		
		private void changeColor(){
			if(MainClass.affichage==Affichage.ROSE){
				this.setBackground(new Color(8,67,107));
			}
			else if(MainClass.affichage==Affichage.SIMPLE){
				this.setBackground(new Color(255,255,255));
			}
			else if(MainClass.affichage==Affichage.INVERSE){
				this.setBackground(new Color(8,67,107));
			}
			else{
				this.setBackground(new Color(0,113,188));
			}
		}
		
		private Color changeTextColor(){
			if(MainClass.affichage==Affichage.ROSE){
				return Color.YELLOW;
			}
			else if(MainClass.affichage==Affichage.SIMPLE){
				return Color.BLACK;
			}
			else{
				return Color.WHITE;
			}
		}

		protected void init() {
			this.jauge = new Jauge();
			this.score = new Score_de_niveau();
			this.changeColor();
			MainClass.score_actuel = new Score_de_niveau();
			repaint();
		}

		@Override
		public void paintComponent(Graphics g) {
			g.setFont(new Font("Calibri", Font.PLAIN, (int)Math.round(MainClass.ratioWidth*70)));
			g.setColor(changeTextColor());
			Graphics2D g2d = (Graphics2D) g;
			super.paintComponent(g2d);
			jauge.draw(g2d, (int)Math.round(MainClass.ratioWidth*500), (int)Math.round(MainClass.ratioHeight*230));
			score.draw(g2d, (int)Math.round(MainClass.ratioWidth*400), (int)Math.round(MainClass.ratioHeight*700));
			g2d.drawString("Bravo ! Tu as terminé le niveau "+this.niveau+" ! ", 
					(int)Math.round(MainClass.ratioWidth*320), (int)Math.round(MainClass.ratioHeight*130));
		}
	}


	@Override
	public void changeColor() {
		// TODO Auto-generated method stub
		
	}
}
