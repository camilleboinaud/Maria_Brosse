package elements;

import grid.Map;

import java.awt.Rectangle;

import main.MainClass;

public class Luffy extends Personnage{

	public Luffy(int centerX, int centerY, Map map) {
		super(centerX,centerY,map,128,64);
	}

	public void initImages() {
			DROITE_1 = MainClass.imageLoad.catchImage("../ressources/images/persoLuffy/d1.png",persoHeight,persoWidth);
			GAUCHE_1 = MainClass.imageLoad.catchImage("../ressources/images/persoLuffy/g1.png",persoHeight,persoWidth);
			DROITE_2 = MainClass.imageLoad.catchImage("../ressources/images/persoLuffy/d2.png",persoHeight,persoWidth);
			GAUCHE_2 = MainClass.imageLoad.catchImage("../ressources/images/persoLuffy/g2.png",persoHeight,persoWidth);
			CHUTE = MainClass.imageLoad.catchImage("../ressources/images/persoLuffy/t.png",persoHeight,persoWidth);
			ATTENTE_D = MainClass.imageLoad.catchImage("../ressources/images/persoLuffy/ad.png",persoHeight,persoWidth);
			ATTENTE_G= MainClass.imageLoad.catchImage("../ressources/images/persoLuffy/ag.png",persoHeight,persoWidth);
			setImageCourante(ATTENTE_D);
			setCompteurPas(0);
	}
}
