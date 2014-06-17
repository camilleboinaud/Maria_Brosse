package score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.MainClass;
import jeu.Chrono;


public class GestionScore {

	private int score_niveau;
	private Chrono chrono;
	
	public GestionScore(int score_niveau, Chrono chrono){
		this.score_niveau=score_niveau;
		this.chrono = chrono;
	}
	
	public void ecritureScore() {
		String chemin = ".." + File.separator + "ressources" + File.separator + "score.txt";
		int temps = this.chrono.getTempsEnSecondes();
		this.score_niveau = this.score_niveau-temps;
		if(this.score_niveau < 0)
			this.score_niveau = 0;

		String contenu = this.recupererContenuScore(recupererNombreDeLigne()-1);
		String ligne = this.recupererDerniereLigne();
		int score = Integer.parseInt(ligne);
		score= score + score_niveau;
		String score_a_ecrire = Integer.toString(score);
		contenu = contenu +score;
		MainClass.scoreActuel = score;
		try  {
			FileWriter w = new FileWriter(chemin);
			w.write(contenu);
			w.close();	
		}
		catch(IOException e){
			System.out.println("probleme à l'écriture entres 2 niveaux");
		}
	}
	
	public void ecritureScoreNull() {
		String chemin = ".." + File.separator + "ressources" + File.separator + "score.txt";
		this.score_niveau = 0;

		String contenu = this.recupererContenuScore(recupererNombreDeLigne()-1);
		String ligne = this.recupererDerniereLigne();
		int score = Integer.parseInt(ligne);
		score= score + score_niveau;
		String score_a_ecrire = Integer.toString(score);
		contenu = contenu +score;
		try  {
			FileWriter w = new FileWriter(chemin);
			w.write(contenu);
			w.close();	
		}
		catch(IOException e){
			System.out.println("probleme à l'écriture entres 2 niveaux");
		}
	}
	
	public String recupererContenuScore(int nb_ligne) {
		String chemin = ".." + File.separator + "ressources" + File.separator + "score.txt";
		String contenu = "";
		try {
			FileReader r = new FileReader(chemin);
			BufferedReader lecteur = new BufferedReader(r);
			for(int i = 1;i<=nb_ligne;i++){
				String l_tmp = lecteur.readLine();
				contenu = contenu +l_tmp+"\n";
			}
			r.close();
			lecteur.close();
		}
		catch(IOException e){
			System.out.println("probleme");
		}
		return contenu;
	}
	
	public String recupererDerniereLigne() {
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
			System.out.println("probleme");
		}
		return ligne;
	}
	public int recupererNombreDeLigne() {
		String chemin = ".." + File.separator + "ressources" + File.separator + "score.txt";
		int nb_ligne = 0;
		try {
			FileReader r = new FileReader(chemin);
			BufferedReader lecteur = new BufferedReader(r);
			while(lecteur.readLine()!=null){
				nb_ligne++;
			}
			r.close();
			lecteur.close();
		}
		catch(IOException e){
			System.out.println("probleme");
		}
		return nb_ligne;
	}	
	
	public void initScore() {
		String chemin = ".." + File.separator + "ressources" + File.separator + "score.txt";
		String contenu = this.recupererContenuScore(recupererNombreDeLigne());
		try {
			FileWriter w = new FileWriter(chemin);
			w.write(contenu+"0\n");
			w.close();
		}
		catch(IOException e){
			System.out.println("le fichier de score n'a pas été trouvé");
		}
	}
	
}
