package elements;

import grid.Map;

import java.awt.Rectangle;

import main.MainClass;

public class Spacy extends Personnage {

	public Spacy(int centerX, int centerY, Map map) {
		super(centerX,centerY,map,128,64);
	}

	public void initImages() {
			DROITE_1 = MainClass.imageLoad.catchImage("../ressources/images/persoSpacy/d1.png",persoHeight,persoWidth);
			GAUCHE_1 = MainClass.imageLoad.catchImage("../ressources/images/persoSpacy/g1.png",persoHeight,persoWidth);
			DROITE_2 = MainClass.imageLoad.catchImage("../ressources/images/persoSpacy/d2.png",persoHeight,persoWidth);
			GAUCHE_2 = MainClass.imageLoad.catchImage("../ressources/images/persoSpacy/g2.png",persoHeight,persoWidth);
			CHUTE = MainClass.imageLoad.catchImage("../ressources/images/persoSpacy/t.png",persoHeight,persoWidth);
			ATTENTE_D = MainClass.imageLoad.catchImage("../ressources/images/persoSpacy/ad.png",persoHeight,persoWidth);
			ATTENTE_G= MainClass.imageLoad.catchImage("../ressources/images/persoSpacy/ag.png",persoHeight,persoWidth);
			setImageCourante(ATTENTE_D);
			setCompteurPas(0);
	}
}
