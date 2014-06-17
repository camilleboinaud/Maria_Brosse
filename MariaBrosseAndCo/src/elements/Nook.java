package elements;

import grid.Map;

import java.awt.Rectangle;

import main.MainClass;

public class Nook extends Personnage{

	public Nook(int centerX, int centerY, Map map) {
		super(centerX,centerY,map,128,64);
	}

	public void initImages() {
			DROITE_1 = MainClass.imageLoad.catchImage("../ressources/images/persoNook/d.png",persoHeight,persoWidth);
			GAUCHE_1 = MainClass.imageLoad.catchImage("../ressources/images/persoNook/g.png",persoHeight,persoWidth);
			DROITE_2 = MainClass.imageLoad.catchImage("../ressources/images/persoNook/d1.png",persoHeight,persoWidth);
			GAUCHE_2 = MainClass.imageLoad.catchImage("../ressources/images/persoNook/g1.png",persoHeight,persoWidth);
			CHUTE = MainClass.imageLoad.catchImage("../ressources/images/persoNook/t.png",persoHeight,persoWidth);
			ATTENTE_D = MainClass.imageLoad.catchImage("../ressources/images/persoNook/ad.png",persoHeight,persoWidth);
			ATTENTE_G= MainClass.imageLoad.catchImage("../ressources/images/persoNook/ag.png",persoHeight,persoWidth);
			setImageCourante(ATTENTE_D);
			setCompteurPas(0);
	}
}
