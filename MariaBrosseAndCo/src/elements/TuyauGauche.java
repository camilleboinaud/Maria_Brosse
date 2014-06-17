package elements;

import grid.Map;

import java.awt.Image;

import main.MainClass;
//TODO : bug durant l'ajout d'un tuyau de ce type dans le panneau .
public class TuyauGauche extends Element{
	private Couleur couleur;
	private Image image;//l'image de l'élément
	private boolean passage;//savoir si Maria peut passer sous l'élément .
	private int x;//abscisse en PIXEL
	private int y;//ordonnee en PIXEL
	
	public TuyauGauche(int x,int y,Couleur couleur,ImageLoad imageLoad) {
		super(x, y,128, 196,TypeElt.GAUCHE,couleur, imageLoad);
		this.couleur = couleur;
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
			this.path_image = repo+"tuyau_bleu_clair_gauche.png";
			break;
		case BLEU_FONCE:
			this.path_image = repo+"tuyau_bleu_fonce_gauche.png";
			break;
		case ENTREE:
			this.path_image = repo+"tuyau_entree_gauche.png";
			break;
		case JAUNE:
			this.path_image = repo+"tuyau_jaune_gauche.png";
			break;
		case ROUGE:
			this.path_image = repo+"tuyau_rouge_gauche.png";
			break;
		case SORTIE:
			this.path_image = repo+"tuyau_sortie_gauche.png";
			break;
		case VERT:
			this.path_image = repo+"tuyau_vert_gauche.png";
			break;
		case VIOLET:
			this.path_image = repo+"tuyau_violet_gauche.png";
			break;
		case MARRON:
			this.path_image = repo+"tuyau_marron_gauche.png";
			break;
		case GRIS:
			this.path_image = repo+"tuyau_gris_gauche.png";
			break;
		default:
			break;

		}
	}

}
