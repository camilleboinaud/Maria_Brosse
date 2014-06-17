package jeu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.MainClass;

public class Jauge implements ImageObserver {
	private Image jauge_actuelle;
	private static String path = "../ressources/images/bravo.png";
	private int height;
	private int width;

	public Jauge() {
		initImage();
		this.height = (int) Math.round(MainClass.ratioHeight*1.2*this.jauge_actuelle.getHeight(this));
		this.width = (int) Math.round(MainClass.ratioWidth*1.2*this.jauge_actuelle.getWidth(this));
	}

	private void initImage() {
		try {
				this.jauge_actuelle = ImageIO.read(new File(path));

		} catch (IOException e) {
			System.out.println("impossibilité de trouver la jauge");
		}
	}
	
	public void draw(Graphics g,int x,int y) {
		g.drawImage(this.jauge_actuelle, x, y,width, height, this);
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5) {
		return true;
	}
}
