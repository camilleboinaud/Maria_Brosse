package elements;

import grid.Affichage;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import main.MainClass;
public class ImageLoad {

		private HashMap<String,BufferedImage> imageLoad;
		
		public ImageLoad(){
			imageLoad = new HashMap<String,BufferedImage>();
			try {
				this.fillMap();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void fillMap() throws IOException{
		imageLoad.put("../ressources/images/bloc_noir.png", ImageIO.read(new File("../ressources/images/bloc_noir.png")));
		imageLoad.put("../ressources/images/neutre.png", ImageIO.read(new File("../ressources/images/neutre.png")));

		if(MainClass.affichage == Affichage.BLEU){
			imageLoad.put("../ressources/images/bleu/tuyau_bleu_clair_haut.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_bleu_clair_haut.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_bleu_fonce_haut.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_bleu_fonce_haut.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_entree.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_entree.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_jaune_haut.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_jaune_haut.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_sortie.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_sortie.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_vert_haut.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_vert_haut.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_violet_haut.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_violet_haut.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_rouge_haut.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_rouge_haut.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_marron_haut.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_marron_haut.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_gris_haut.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_gris_haut.png")));
		
			imageLoad.put("../ressources/images/bleu/tuyau_bleu_clair_bas.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_bleu_clair_bas.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_bleu_fonce_bas.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_bleu_fonce_bas.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_entree_bas.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_entree_bas.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_jaune_bas.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_jaune_bas.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_vert_bas.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_vert_bas.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_violet_bas.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_violet_bas.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_rouge_bas.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_rouge_bas.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_marron_bas.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_marron_bas.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_gris_bas.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_gris_bas.png")));
		
			imageLoad.put("../ressources/images/bleu/tuyau_bleu_clair_gauche.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_bleu_clair_gauche.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_bleu_fonce_gauche.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_bleu_fonce_gauche.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_entree_gauche.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_entree_gauche.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_jaune_gauche.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_jaune_gauche.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_sortie_gauche.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_sortie_gauche.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_vert_gauche.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_vert_gauche.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_violet_gauche.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_violet_gauche.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_rouge_gauche.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_rouge_gauche.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_marron_gauche.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_marron_gauche.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_gris_gauche.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_gris_gauche.png")));
	
			imageLoad.put("../ressources/images/bleu/tuyau_bleu_clair_droite.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_bleu_clair_droite.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_bleu_fonce_droite.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_bleu_fonce_droite.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_entree_droite.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_entree_droite.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_jaune_droite.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_jaune_droite.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_sortie_droite.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_sortie_droite.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_vert_droite.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_vert_droite.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_violet_droite.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_violet_droite.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_rouge_droite.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_rouge_droite.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_marron_droite.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_marron_droite.png")));
			imageLoad.put("../ressources/images/bleu/tuyau_gris_droite.png", ImageIO.read(new File("../ressources/images/bleu/tuyau_gris_droite.png")));
		
		} else if (MainClass.affichage == Affichage.ROSE){
			imageLoad.put("../ressources/images/rose/tuyau_bleu_clair_haut.png", ImageIO.read(new File("../ressources/images/rose/tuyau_bleu_clair_haut.png")));
			imageLoad.put("../ressources/images/rose/tuyau_bleu_fonce_haut.png", ImageIO.read(new File("../ressources/images/rose/tuyau_bleu_fonce_haut.png")));
			imageLoad.put("../ressources/images/rose/tuyau_entree.png", ImageIO.read(new File("../ressources/images/rose/tuyau_entree.png")));
			imageLoad.put("../ressources/images/rose/tuyau_jaune_haut.png", ImageIO.read(new File("../ressources/images/rose/tuyau_jaune_haut.png")));
			imageLoad.put("../ressources/images/rose/tuyau_sortie.png", ImageIO.read(new File("../ressources/images/rose/tuyau_sortie.png")));
			imageLoad.put("../ressources/images/rose/tuyau_vert_haut.png", ImageIO.read(new File("../ressources/images/rose/tuyau_vert_haut.png")));
			imageLoad.put("../ressources/images/rose/tuyau_violet_haut.png", ImageIO.read(new File("../ressources/images/rose/tuyau_violet_haut.png")));
			imageLoad.put("../ressources/images/rose/tuyau_rouge_haut.png", ImageIO.read(new File("../ressources/images/rose/tuyau_rouge_haut.png")));
			imageLoad.put("../ressources/images/rose/tuyau_marron_haut.png", ImageIO.read(new File("../ressources/images/rose/tuyau_marron_haut.png")));
			imageLoad.put("../ressources/images/rose/tuyau_gris_haut.png", ImageIO.read(new File("../ressources/images/rose/tuyau_gris_haut.png")));
	
			imageLoad.put("../ressources/images/rose/tuyau_bleu_clair_bas.png", ImageIO.read(new File("../ressources/images/rose/tuyau_bleu_clair_bas.png")));
			imageLoad.put("../ressources/images/rose/tuyau_bleu_fonce_bas.png", ImageIO.read(new File("../ressources/images/rose/tuyau_bleu_fonce_bas.png")));
			imageLoad.put("../ressources/images/rose/tuyau_entree_bas.png", ImageIO.read(new File("../ressources/images/rose/tuyau_entree_bas.png")));
			imageLoad.put("../ressources/images/rose/tuyau_jaune_bas.png", ImageIO.read(new File("../ressources/images/rose/tuyau_jaune_bas.png")));
			imageLoad.put("../ressources/images/rose/tuyau_vert_bas.png", ImageIO.read(new File("../ressources/images/rose/tuyau_vert_bas.png")));
			imageLoad.put("../ressources/images/rose/tuyau_violet_bas.png", ImageIO.read(new File("../ressources/images/rose/tuyau_violet_bas.png")));
			imageLoad.put("../ressources/images/rose/tuyau_rouge_bas.png", ImageIO.read(new File("../ressources/images/rose/tuyau_rouge_bas.png")));
			imageLoad.put("../ressources/images/rose/tuyau_marron_bas.png", ImageIO.read(new File("../ressources/images/rose/tuyau_marron_bas.png")));
			imageLoad.put("../ressources/images/rose/tuyau_gris_bas.png", ImageIO.read(new File("../ressources/images/rose/tuyau_gris_bas.png")));
		
			imageLoad.put("../ressources/images/rose/tuyau_bleu_clair_gauche.png", ImageIO.read(new File("../ressources/images/rose/tuyau_bleu_clair_gauche.png")));
			imageLoad.put("../ressources/images/rose/tuyau_bleu_fonce_gauche.png", ImageIO.read(new File("../ressources/images/rose/tuyau_bleu_fonce_gauche.png")));
			imageLoad.put("../ressources/images/rose/tuyau_entree_gauche.png", ImageIO.read(new File("../ressources/images/rose/tuyau_entree_gauche.png")));
			imageLoad.put("../ressources/images/rose/tuyau_jaune_gauche.png", ImageIO.read(new File("../ressources/images/rose/tuyau_jaune_gauche.png")));
			imageLoad.put("../ressources/images/rose/tuyau_sortie_gauche.png", ImageIO.read(new File("../ressources/images/rose/tuyau_sortie_gauche.png")));
			imageLoad.put("../ressources/images/rose/tuyau_vert_gauche.png", ImageIO.read(new File("../ressources/images/rose/tuyau_vert_gauche.png")));
			imageLoad.put("../ressources/images/rose/tuyau_violet_gauche.png", ImageIO.read(new File("../ressources/images/rose/tuyau_violet_gauche.png")));
			imageLoad.put("../ressources/images/rose/tuyau_rouge_gauche.png", ImageIO.read(new File("../ressources/images/rose/tuyau_rouge_gauche.png")));
			imageLoad.put("../ressources/images/rose/tuyau_marron_gauche.png", ImageIO.read(new File("../ressources/images/rose/tuyau_marron_gauche.png")));
			imageLoad.put("../ressources/images/rose/tuyau_gris_gauche.png", ImageIO.read(new File("../ressources/images/rose/tuyau_gris_gauche.png")));
			
			imageLoad.put("../ressources/images/rose/tuyau_bleu_clair_droite.png", ImageIO.read(new File("../ressources/images/rose/tuyau_bleu_clair_droite.png")));
			imageLoad.put("../ressources/images/rose/tuyau_bleu_fonce_droite.png", ImageIO.read(new File("../ressources/images/rose/tuyau_bleu_fonce_droite.png")));
			imageLoad.put("../ressources/images/rose/tuyau_entree_droite.png", ImageIO.read(new File("../ressources/images/rose/tuyau_entree_droite.png")));
			imageLoad.put("../ressources/images/rose/tuyau_jaune_droite.png", ImageIO.read(new File("../ressources/images/rose/tuyau_jaune_droite.png")));
			imageLoad.put("../ressources/images/rose/tuyau_sortie_droite.png", ImageIO.read(new File("../ressources/images/rose/tuyau_sortie_droite.png")));
			imageLoad.put("../ressources/images/rose/tuyau_vert_droite.png", ImageIO.read(new File("../ressources/images/rose/tuyau_vert_droite.png")));
			imageLoad.put("../ressources/images/rose/tuyau_violet_droite.png", ImageIO.read(new File("../ressources/images/rose/tuyau_violet_droite.png")));
			imageLoad.put("../ressources/images/rose/tuyau_rouge_droite.png", ImageIO.read(new File("../ressources/images/rose/tuyau_rouge_droite.png")));
			imageLoad.put("../ressources/images/rose/tuyau_marron_droite.png", ImageIO.read(new File("../ressources/images/rose/tuyau_marron_droite.png")));
			imageLoad.put("../ressources/images/rose/tuyau_gris_droite.png", ImageIO.read(new File("../ressources/images/rose/tuyau_gris_droite.png")));
		} else{
			imageLoad.put("../ressources/images/simple/tuyau_bleu_clair_haut.png", ImageIO.read(new File("../ressources/images/simple/tuyau_bleu_clair_haut.png")));
			imageLoad.put("../ressources/images/simple/tuyau_bleu_fonce_haut.png", ImageIO.read(new File("../ressources/images/simple/tuyau_bleu_fonce_haut.png")));
			imageLoad.put("../ressources/images/simple/tuyau_entree.png", ImageIO.read(new File("../ressources/images/simple/tuyau_entree.png")));
			imageLoad.put("../ressources/images/simple/tuyau_jaune_haut.png", ImageIO.read(new File("../ressources/images/simple/tuyau_jaune_haut.png")));
			imageLoad.put("../ressources/images/simple/tuyau_sortie.png", ImageIO.read(new File("../ressources/images/simple/tuyau_sortie.png")));
			imageLoad.put("../ressources/images/simple/tuyau_vert_haut.png", ImageIO.read(new File("../ressources/images/simple/tuyau_vert_haut.png")));
			imageLoad.put("../ressources/images/simple/tuyau_violet_haut.png", ImageIO.read(new File("../ressources/images/simple/tuyau_violet_haut.png")));
			imageLoad.put("../ressources/images/simple/tuyau_rouge_haut.png", ImageIO.read(new File("../ressources/images/simple/tuyau_rouge_haut.png")));
			imageLoad.put("../ressources/images/simple/tuyau_marron_haut.png", ImageIO.read(new File("../ressources/images/simple/tuyau_marron_haut.png")));
			imageLoad.put("../ressources/images/simple/tuyau_gris_haut.png", ImageIO.read(new File("../ressources/images/simple/tuyau_gris_haut.png")));
			
	
			imageLoad.put("../ressources/images/simple/tuyau_bleu_clair_bas.png", ImageIO.read(new File("../ressources/images/simple/tuyau_bleu_clair_bas.png")));
			imageLoad.put("../ressources/images/simple/tuyau_bleu_fonce_bas.png", ImageIO.read(new File("../ressources/images/simple/tuyau_bleu_fonce_bas.png")));
			imageLoad.put("../ressources/images/simple/tuyau_entree_bas.png", ImageIO.read(new File("../ressources/images/simple/tuyau_entree_bas.png")));
			imageLoad.put("../ressources/images/simple/tuyau_jaune_bas.png", ImageIO.read(new File("../ressources/images/simple/tuyau_jaune_bas.png")));
			imageLoad.put("../ressources/images/simple/tuyau_vert_bas.png", ImageIO.read(new File("../ressources/images/simple/tuyau_vert_bas.png")));
			imageLoad.put("../ressources/images/simple/tuyau_violet_bas.png", ImageIO.read(new File("../ressources/images/simple/tuyau_violet_bas.png")));
			imageLoad.put("../ressources/images/simple/tuyau_rouge_bas.png", ImageIO.read(new File("../ressources/images/simple/tuyau_rouge_bas.png")));
			imageLoad.put("../ressources/images/simple/tuyau_marron_bas.png", ImageIO.read(new File("../ressources/images/simple/tuyau_marron_bas.png")));
			imageLoad.put("../ressources/images/simple/tuyau_gris_bas.png", ImageIO.read(new File("../ressources/images/simple/tuyau_gris_bas.png")));
			
			imageLoad.put("../ressources/images/simple/tuyau_bleu_clair_gauche.png", ImageIO.read(new File("../ressources/images/simple/tuyau_bleu_clair_gauche.png")));
			imageLoad.put("../ressources/images/simple/tuyau_bleu_fonce_gauche.png", ImageIO.read(new File("../ressources/images/simple/tuyau_bleu_fonce_gauche.png")));
			imageLoad.put("../ressources/images/simple/tuyau_entree_gauche.png", ImageIO.read(new File("../ressources/images/simple/tuyau_entree_gauche.png")));
			imageLoad.put("../ressources/images/simple/tuyau_jaune_gauche.png", ImageIO.read(new File("../ressources/images/simple/tuyau_jaune_gauche.png")));
			imageLoad.put("../ressources/images/simple/tuyau_sortie_gauche.png", ImageIO.read(new File("../ressources/images/simple/tuyau_sortie_gauche.png")));
			imageLoad.put("../ressources/images/simple/tuyau_vert_gauche.png", ImageIO.read(new File("../ressources/images/simple/tuyau_vert_gauche.png")));
			imageLoad.put("../ressources/images/simple/tuyau_violet_gauche.png", ImageIO.read(new File("../ressources/images/simple/tuyau_violet_gauche.png")));
			imageLoad.put("../ressources/images/simple/tuyau_rouge_gauche.png", ImageIO.read(new File("../ressources/images/simple/tuyau_rouge_gauche.png")));
			imageLoad.put("../ressources/images/simple/tuyau_marron_gauche.png", ImageIO.read(new File("../ressources/images/simple/tuyau_marron_gauche.png")));
			imageLoad.put("../ressources/images/simple/tuyau_gris_gauche.png", ImageIO.read(new File("../ressources/images/simple/tuyau_gris_gauche.png")));
			
			imageLoad.put("../ressources/images/simple/tuyau_bleu_clair_droite.png", ImageIO.read(new File("../ressources/images/simple/tuyau_bleu_clair_droite.png")));
			imageLoad.put("../ressources/images/simple/tuyau_bleu_fonce_droite.png", ImageIO.read(new File("../ressources/images/simple/tuyau_bleu_fonce_droite.png")));
			imageLoad.put("../ressources/images/simple/tuyau_entree_droite.png", ImageIO.read(new File("../ressources/images/simple/tuyau_entree_droite.png")));
			imageLoad.put("../ressources/images/simple/tuyau_jaune_droite.png", ImageIO.read(new File("../ressources/images/simple/tuyau_jaune_droite.png")));
			imageLoad.put("../ressources/images/simple/tuyau_sortie_droite.png", ImageIO.read(new File("../ressources/images/simple/tuyau_sortie_droite.png")));
			imageLoad.put("../ressources/images/simple/tuyau_vert_droite.png", ImageIO.read(new File("../ressources/images/simple/tuyau_vert_droite.png")));
			imageLoad.put("../ressources/images/simple/tuyau_violet_droite.png", ImageIO.read(new File("../ressources/images/simple/tuyau_violet_droite.png")));
			imageLoad.put("../ressources/images/simple/tuyau_rouge_droite.png", ImageIO.read(new File("../ressources/images/simple/tuyau_rouge_droite.png")));
			imageLoad.put("../ressources/images/simple/tuyau_marron_droite.png", ImageIO.read(new File("../ressources/images/simple/tuyau_marron_droite.png")));
			imageLoad.put("../ressources/images/simple/tuyau_gris_droite.png", ImageIO.read(new File("../ressources/images/simple/tuyau_gris_droite.png")));
		}
		
		switch(MainClass.perso){
		case 2 :
			imageLoad.put("../ressources/images/persoSpacy/d1.png", ImageIO.read(new File("../ressources/images/persoSpacy/d1.png")));
			imageLoad.put("../ressources/images/persoSpacy/d2.png", ImageIO.read(new File("../ressources/images/persoSpacy/d2.png")));
			imageLoad.put("../ressources/images/persoSpacy/g1.png", ImageIO.read(new File("../ressources/images/persoSpacy/g1.png")));
			imageLoad.put("../ressources/images/persoSpacy/g2.png", ImageIO.read(new File("../ressources/images/persoSpacy/g2.png")));
			imageLoad.put("../ressources/images/persoSpacy/t.png", ImageIO.read(new File("../ressources/images/persoSpacy/t.png")));
			imageLoad.put("../ressources/images/persoSpacy/ad.png", ImageIO.read(new File("../ressources/images/persoSpacy/ad.png")));
			imageLoad.put("../ressources/images/persoSpacy/ag.png", ImageIO.read(new File("../ressources/images/persoSpacy/ag.png")));
			break;
		case 3 : 
			imageLoad.put("../ressources/images/persoNook/d1.png", ImageIO.read(new File("../ressources/images/persoNook/d1.png")));
			imageLoad.put("../ressources/images/persoNook/g1.png", ImageIO.read(new File("../ressources/images/persoNook/g1.png")));
			imageLoad.put("../ressources/images/persoNook/d.png", ImageIO.read(new File("../ressources/images/persoNook/d.png")));
			imageLoad.put("../ressources/images/persoNook/g.png", ImageIO.read(new File("../ressources/images/persoNook/g.png")));
			imageLoad.put("../ressources/images/persoNook/t.png", ImageIO.read(new File("../ressources/images/persoNook/t.png")));
			imageLoad.put("../ressources/images/persoNook/ag.png", ImageIO.read(new File("../ressources/images/persoNook/ag.png")));
			imageLoad.put("../ressources/images/persoNook/ad.png", ImageIO.read(new File("../ressources/images/persoNook/ad.png")));
			break;
		case 4 :
			imageLoad.put("../ressources/images/persoLuffy/d1.png", ImageIO.read(new File("../ressources/images/persoLuffy/d1.png")));
			imageLoad.put("../ressources/images/persoLuffy/g1.png", ImageIO.read(new File("../ressources/images/persoLuffy/g1.png")));
			imageLoad.put("../ressources/images/persoLuffy/d2.png", ImageIO.read(new File("../ressources/images/persoLuffy/d2.png")));
			imageLoad.put("../ressources/images/persoLuffy/g2.png", ImageIO.read(new File("../ressources/images/persoLuffy/g2.png")));
			imageLoad.put("../ressources/images/persoLuffy/t.png", ImageIO.read(new File("../ressources/images/persoLuffy/t.png")));
			imageLoad.put("../ressources/images/persoLuffy/ag.png", ImageIO.read(new File("../ressources/images/persoLuffy/ag.png")));
			imageLoad.put("../ressources/images/persoLuffy/ad.png", ImageIO.read(new File("../ressources/images/persoLuffy/ad.png")));
			break;
		case 5 :
			imageLoad.put("../ressources/images/persoKirby/d1.png", ImageIO.read(new File("../ressources/images/persoKirby/d1.png")));
			imageLoad.put("../ressources/images/persoKirby/g1.png", ImageIO.read(new File("../ressources/images/persoKirby/g1.png")));
			imageLoad.put("../ressources/images/persoKirby/d2.png", ImageIO.read(new File("../ressources/images/persoKirby/d2.png")));
			imageLoad.put("../ressources/images/persoKirby/g2.png", ImageIO.read(new File("../ressources/images/persoKirby/g2.png")));
			imageLoad.put("../ressources/images/persoKirby/t.png", ImageIO.read(new File("../ressources/images/persoKirby/t.png")));
			imageLoad.put("../ressources/images/persoKirby/ag.png", ImageIO.read(new File("../ressources/images/persoKirby/ag.png")));
			imageLoad.put("../ressources/images/persoKirby/ad.png", ImageIO.read(new File("../ressources/images/persoKirby/ad.png")));
		break;
		default :
			imageLoad.put("../ressources/images/persoMaria/maria_pas1d.png", ImageIO.read(new File("../ressources/images/persoMaria/maria_pas1d.png")));
			imageLoad.put("../ressources/images/persoMaria/maria_pas1g.png", ImageIO.read(new File("../ressources/images/persoMaria/maria_pas1g.png")));
			imageLoad.put("../ressources/images/persoMaria/maria_pas2d.png", ImageIO.read(new File("../ressources/images/persoMaria/maria_pas2d.png")));
			imageLoad.put("../ressources/images/persoMaria/maria_pas2g.png", ImageIO.read(new File("../ressources/images/persoMaria/maria_pas2g.png")));
			imageLoad.put("../ressources/images/persoMaria/maria_tombe.png", ImageIO.read(new File("../ressources/images/persoMaria/maria_tombe.png")));
			imageLoad.put("../ressources/images/persoMaria/attenteg.png", ImageIO.read(new File("../ressources/images/persoMaria/attenteg.png")));
			imageLoad.put("../ressources/images/persoMaria/attented.png", ImageIO.read(new File("../ressources/images/persoMaria/attented.png")));
			imageLoad.put("../ressources/images/persoMaria/completelevel.png", ImageIO.read(new File("../ressources/images/persoMaria/completelevel.png")));
			break;
		}


		}
		
		public Image catchImage(String path, int height, int width){
			BufferedImage image = imageLoad.get(path);
			BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(image, 0, 0, width, height, null);
			g.dispose();
					
			imageLoad.remove(path);
			imageLoad.put(path, resizedImage);
			
			return resizedImage;
		}
}
