package jeu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import main.MainClass;
import t2s.SIVOXDevint;
import devintAPI.MenuAbstrait;

/** Cette classe est un exemple d'utilisation d'un fichier
 * 
 * @author helene
 * @author Jean-Paul, mars 2011
 */

//jlai mis ne menu abstrait car du ocup c'est plus simple, et en plus le joueur peut entendre le score quand
//il clique dessus ;)
public class Score extends MenuAbstrait{

private SIVOXDevint voix;
private static int score=1000;

	public Score(String title) {
		super(title);
		if(MainClass.frame!=null) MainClass.frame.dispose();
		MainClass.frame = this;
	}

	/**
	 * Mï¿½thode lisant ligne ï¿½ ligne les scores et retournant un tableau de scores .
	 * @return
	 */
	private ArrayList<Integer> lectureFichierScores(){
		String pathScore = ".." + File.separator + "ressources" + File.separator + "score.txt";
		ArrayList<Integer> scores = new ArrayList<Integer>();
		try {
			BufferedReader lScore = new BufferedReader(new FileReader(pathScore));

			String line;
			while((line = lScore.readLine())!=null){
				int score = Integer.parseInt(line);
				scores.add(score);
			}
			lScore.close();
		}
		catch (IOException e) {
			System.out.println("le fichier "+pathScore+" n'a pas Ã©tÃ© trouvÃ©");
		}
		return scores;
	}
	
	private ArrayList<String> lectureFichierPrenom(){
		String pathPrenom = ".." + File.separator + "ressources" + File.separator + "prenom.txt";
		ArrayList<String> prenoms = new ArrayList<String>();
		try {
			BufferedReader lPrenom = new BufferedReader(new FileReader(pathPrenom));

			String line;
			while((line = lPrenom.readLine())!=null){
				prenoms.add(line);
			}
			lPrenom.close();
		}
		catch (IOException e) {
			System.out.println("le fichier "+pathPrenom+" n'a pas Ã©tÃ© trouvÃ©");
		}
		return prenoms;
	}
	

	public String[] lireScore() {
		String prenom;
		String score;
		ArrayList<Integer> scores = lectureFichierScores();
		ArrayList<String> prenoms = lectureFichierPrenom();
		String[] scores_max = {"vide","vide","vide","vide"};
		for(int i = 0;i<4;i++){
			int sc = max(scores);
			if(sc!=0){
				int index = scores.indexOf((Integer)sc);
				scores.remove((Integer)sc);
				prenom = prenoms.get(index);
				prenoms.remove(index);
				score = prenom+" : "+Integer.toString(sc);
			} else score = "";
			
			
			scores_max[i]=score;
		}
		return scores_max;
	}
	
	private int max(ArrayList<Integer> scores){
		int max = 0;
		for(int nb : scores) {
			if(nb > max)
				max = nb;
		}
		return max;
	}

	@Override
	public void changeColor() {
	}

	// renvoie le fichier wave contenant le message d'accueil
	protected  String wavAccueil() {
		return "Voici lè méilleur scor du jeu ! Entraine toi avec Maria é sès ami pour battr tou lè recor";
	}

	// renvoie le fichier wave contenant la rï¿½gle du jeu
	protected  String wavRegleJeu() {
		return "";
	}

	// renvoie le fichier wave contenant la rï¿½gle du jeu
	protected  String wavAide() {
		return "../ressources/sons/aide.wav";
	}

	@Override
	protected String[] nomOptions() {
		String[] scores = this.lireScore();
		return scores;
	}

	@Override
	protected void lancerOption(int i) {
		String[] scores = this.lireScore();
		switch(i) {
		case 0: this.voix.playText(scores[0]);break;
		case 1: this.voix.playText(scores[1]);break;
		case 2: this.voix.playText(scores[2]);break;
		case 3: this.voix.playText(scores[3]);break;
		}
	}
}
