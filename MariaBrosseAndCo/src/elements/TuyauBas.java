package elements;

import grid.Map;

import java.awt.Image;

import main.MainClass;

/**
 * Un tuyau vertical prend 3 cases de haut sur 2 cases de large . Faut en tenir compte lorsqu'on 
 * @author Leviathor
 *
 */
public class TuyauBas extends elements.Element 	{
	private Image image;//l'image de l'élément
	private boolean passage;//savoir si Maria peut passer sous l'élément .
	private int x;//abscisse en PIXEL
	private int y;//ordonnee en PIXEL
	
	public TuyauBas(int x,int y,Couleur couleur,ImageLoad imageLoad) {
		super(x, y, 196,128,TypeElt.BAS,couleur, imageLoad);
	}
	
	public void setPath() {
		String repo="";
		switch(MainClass.affichage){
		case BLEU :
			 repo = "../ressources/images/bleu/";
			break;
		case ROSE :
			repo = "../ressources/images/rose/";
			break;
		case SIMPLE :
			repo = "../ressources/images/simple/";
			break;
		case INVERSE :
			repo = "../ressources/images/simple/";
			break;
		default :
			repo = "../ressources/images/bleu/";
			break;
			
		}
		switch(this.couleur){
		case BLEU_CLAIR:
			this.path_image = repo+"tuyau_bleu_clair_bas.png";
			break;
		case BLEU_FONCE:
			this.path_image = repo+"tuyau_bleu_fonce_bas.png";
			break;
		case ENTREE:
			this.path_image = repo+"tuyau_entree_bas.png";
			break;
		case JAUNE:
			this.path_image = repo+"tuyau_jaune_bas.png";
			break;
		case ROUGE:
			this.path_image = repo+"tuyau_rouge_bas.png";
			break;
//pas de case SORTIE car un tuayu sortie qui pointe vers le bas est impossible .
		case VERT:
			this.path_image = repo+"tuyau_vert_bas.png";
			break;
		case VIOLET:
			this.path_image = repo+"tuyau_violet_bas.png";
			break;
		case MARRON:
			this.path_image = repo+"tuyau_marron_bas.png";
			break;
		case GRIS:
			this.path_image = repo+"tuyau_gris_bas.png";
			break;
		case SORTIE:
			this.path_image = repo+"tuyau_sortie_bas.png";
			break;
		default:
			break;

		}
	}
}
