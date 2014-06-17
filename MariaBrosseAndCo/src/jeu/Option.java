package jeu;


import javax.swing.JTextArea;

import sons.AudioWav;
import main.MainClass;
import devintAPI.MenuAbstrait;
import devintAPI.Preferences;
import elements.ImageLoad;

/** Cette classe est un exemple d'interface pour les options
 * 
 */
public class Option extends MenuAbstrait{

    public Option(String title) {
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
		return "S�lectionne un personnage pui appuie sur ENTRER pour lancer le jeu !";
	}
	
	// renvoie le fichier wave contenant la r�gle du jeu
	protected  String wavRegleJeu() {
		return "S�lectionne un personnage pui appuie sur ENTRER pour lancer le jeu !";
	}
	
	// renvoie le fichier wave contenant la r�gle du jeu
	protected  String wavAide() {
		return "../ressources/sons/aide.wav";
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
		String[] noms = {"Maria","Ouistiti","Sheepy", "Robin", "Owen"};
		return noms;
	}

	@Override
	protected void lancerOption(int i) {
		String[] noms = this.nomOptions();
		switch(i) {
		case 0: MainClass.perso=1;break;
		case 1: MainClass.perso=2;break;
		case 2: MainClass.perso=3;break;
		case 3: MainClass.perso=4;break;
		case 4: MainClass.perso=5; break;
		}
		AudioWav.stop();
		MainClass.imageLoad = new ImageLoad();
		AudioWav.loadSounds();
		MainClass.resetLevel(1);
		voix.stop();
	}

	@Override
	protected void setFocusedButton(int i) {
		voix.stop();
		String[] names = {"Mariaa", "Ouistiti", "Chipi", "Robin", "Ohou�ne"};
		boutonOption[i].setBackground(backgroundColor);
		boutonOption[i].setForeground(foregroundColor);
		voix.playShortText(names[i]);
	}
}
