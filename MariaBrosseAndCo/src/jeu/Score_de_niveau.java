package jeu;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import main.MainClass;

public class Score_de_niveau {
	private String score;
	public Score_de_niveau() {
		this.score = this.recupererDerniereLigne();
	}
	
	private String recupererDerniereLigne() {
		String chemin = ".." + File.separator + "ressources" + File.separator + "score.txt";
		String ligne = "";
		try {
			FileReader r = new FileReader(chemin);
			BufferedReader lecteur = new BufferedReader(r);
			String l_tmp = "";
			while((l_tmp = lecteur.readLine())!=null){
				ligne = l_tmp;
			}
			r.close();
			lecteur.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return ligne;
	}
	
	public void draw(Graphics g, int x, int y){
		g.drawString("Ton score actuel est de "+this.score, x, y);
		g.drawString("(appuie sur une touche pour passer au niveau suivant)",
				x-(int)Math.round(MainClass.ratioWidth*370),y+(int)Math.round(MainClass.ratioHeight*70));
	}

	
}
