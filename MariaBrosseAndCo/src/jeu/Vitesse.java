package jeu;


import javax.swing.JTextArea;

import main.MainClass;
import devintAPI.MenuAbstrait;
import devintAPI.Preferences;

/** Cette classe est un exemple d'interface pour les options
 * 
 */
public class Vitesse extends MenuAbstrait{

    public Vitesse(String title) {
    	super(title);
    	if(MainClass.frame!=null) MainClass.frame.dispose();
		MainClass.frame = this;
    }
    
    // un label
	// est une variable d'instance car il doit �tre accessible 
	// dans la m�thode changeColor, qui g�re les pr�f�rences
	private JTextArea lb1;
    
	// renvoie le fichier wave contenant le message d'accueil
	protected  String wavAccueil() {
		return "S�lectionne la vitesse du jeu puis appuie sur ENTRER !";
	}
	
	// renvoie le fichier wave contenant la r�gle du jeu
	protected  String wavRegleJeu() {
		return "S�lectionne la vitesse du jeu puis appuie sur ENTRER !";
	}
	
	// renvoie le fichier wave contenant la r�gle du jeu
	protected  String wavAide() {
		return "";
	}
    
	/**
	 * Pour modifier les couleurs de fond et de premier plan de la fen�tre
	 * Cette fonction est appel�e par la fonction "changeColor" de la classe "Preferences"
	 * � chaque fois que l'on presse F3 
	 * 
	 * on change la couleur du texte principal
	 **/
	public  void changeColor() {
    	// on r�cup�re les couleurs de base dans la classe Preferences 
		Preferences pref = Preferences.getData();
		lb1.setBackground(pref.getCurrentBackgroundColor());
		lb1.setForeground(pref.getCurrentForegroundColor());
	}

	@Override
	protected String[] nomOptions() {
		String[] noms = {"Lent","Moyen","Rapide"};
		return noms;
	}

	@Override
	protected void lancerOption(int i) {
		String[] noms = this.nomOptions();
		switch(i) {
		case 0: MainClass.speed=1;break;
		case 1: MainClass.speed=2;break;
		case 2: MainClass.speed=3;break;
		}
		new Option("Choisis ton personnage !");
	}

	@Override
	protected void setFocusedButton(int i) {
		voix.stop();
		String[] names = {"Vitesse Lente", "Vitesse Moyenne", "Vitesse rapide"};
		boutonOption[i].setBackground(backgroundColor);
		boutonOption[i].setForeground(foregroundColor);
		voix.playShortText(names[i]);
	}
}
