package main;

import java.awt.Cursor;
import java.awt.DisplayMode;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import jeu.Chrono;
import jeu.MenuJeu;
import jeu.Score_de_niveau;
import score.GestionScore;
import sons.AudioWav;
import elements.ImageLoad;
import grid.Affichage;
import grid.Map;
import grid.ScreenManager;

public class MainClass {

	public static JFrame frame;

	public static boolean isOnFullScreen = true;
	public static DisplayMode dm = new DisplayMode(MainClass.screenHeight, MainClass.screenWidth, 64, DisplayMode.REFRESH_RATE_UNKNOWN);
	public static ScreenManager sm = new ScreenManager();
	public static int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	public static double ratioHeight;
	public static double ratioWidth;
	public static int niveauInit;
	public static Score_de_niveau score_actuel;
	public static int limite_de_temps;
	public static Chrono chrono;
	public static GestionScore gestionScore;
	public static int perso;
	public static int speed;
	public static Affichage affichage = Affichage.BLEU;
	public static ImageLoad imageLoad; 
	public static File file;
	public static int scoreActuel = 0;
	



	public static void resetLevel(int niveauInit){
		System.gc();
		MainClass.niveauInit = niveauInit;
		file = new File(initPath());
		chrono = new Chrono();
		if(niveauInit==1){
			limite_de_temps=20;
		} else limite_de_temps+=5*niveauInit;
		if(niveauInit!=-1) gestionScore = new GestionScore(MainClass.limite_de_temps, chrono);
		if(niveauInit==1){
			gestionScore.initScore();
		}
		if(frame!=null)	frame.dispose();

		if(!file.exists()) niveauInit = -1; 

		if(niveauInit!=-1){
			frame = new JFrame("Maria Brosse & Co. Niveau "+niveauInit+" - DEVINT 2014");
			sm.setFullScreen(frame, dm);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			Map map = new Map(niveauInit, imageLoad);
			frame.addKeyListener(map);
			frame.setContentPane(map);
			frame.setCursor(frame.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), null));

			frame.setFocusable(true);
			frame.setVisible(true);
			ImageIcon icon = new ImageIcon ( Toolkit.getDefaultToolkit().getImage("../ressources/images/mariaTete.png"));
			frame.setIconImage(icon.getImage());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else{
	        new jeu.MenuJeu("Maria Brosse & Co.");
		}
	}
	
	private static String initPath(){
		if(niveauInit<10) return "../ressources/map0"+niveauInit+".txt";
		else return "../ressources/map"+niveauInit+".txt";
	}
}
