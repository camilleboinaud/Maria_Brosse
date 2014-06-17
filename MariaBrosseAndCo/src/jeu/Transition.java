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

public class Transition extends FenetreAbstraite{
	private Panel panel;
	private int niveau;
	private AudioWav audio;
	private boolean canQuit = false;
	
	
	public Transition() {
		super("");
		Panel panel = new Panel();
		this.add(panel);
 		this.setVisible(true);
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
				default:
					this.dispose();
					break;
			}
		}
	}
	

	private class Panel extends JPanel{
		
		public Panel() {
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
			this.changeColor();
			repaint();
		}

		@Override
		public void paintComponent(Graphics g) {
		}
	}


	@Override
	public void changeColor() {
		// TODO Auto-generated method stub
		
	}
}
