/* Classe de menu de lancement de l'exemple de jeu.
 * Cette classe hérite de la classe abstraite MenuAbstrait en définissant les méthodes :
 * - nomOptions qui renvoie la liste des options possibles pour le menu
 * - lancerOption qui associe une action à chaque option du menu
 * - wavAccueil() qui renvoie le nom du fichier wav lu lors de l'accueil dans le menu
 * - wavAide() qui renvoie le nom du fichier wav lu lors de l'activation de la touche F1
 */

package jeu;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import main.MainClass;
import devintAPI.MenuAbstrait;

public class MenuJeu extends MenuAbstrait {

	/** constructeur
	 * @param title : le nom du jeu
	 */
	public MenuJeu(String title) {
		super(title);
		if(MainClass.frame!=null) MainClass.frame.dispose();
		MainClass.frame = this;
		voix.playWav("../ressources/sons/menu.wav");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../ressources/images/mariaTete.png")); 
	}

	@Override
	protected void processWindowEvent(WindowEvent we) {
		if(we.WINDOW_CLOSING == we.getID())
			fermerFenetre();
	}

	private void fermerFenetre() {
		voix.stop();
		dispose();
		System.exit(0);
	}

	/** renvoie le nom des options du menu
	 * vous pouvez définir autant d'options que vous voulez
	 **/
	protected String[] nomOptions() {
		String[] noms = {"Jouer","Scores","Quitter"};
		return noms;
	}

	/** lance l'action associée au bouton n°i
	 * la numérotation est celle du tableau renvoyé par nomOption
	 */
	protected void lancerOption(int i) {
		switch (i){
		case 0 :
			new EntreTonNom();
			break;
		case 1 : new Score("Vos meilleurs scores !");break;
		case 2 : System.exit(0);
		default: System.err.println("action non définie");
		}
	}

	// renvoie le fichier wave contenant le message d'accueil
	// ces fichiers doivent être placés dans ressources/sons/
	protected String wavAccueil() {
		return "Maria Brosse é companie";
	}

	// renvoie le fichier wave contenant la règle du jeu
	protected String wavRegleJeu() {
		return "../ressources/sons/accueil.wav";
	}


}