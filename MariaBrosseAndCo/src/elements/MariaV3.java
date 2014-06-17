package elements;

import grid.Map;

import java.awt.Rectangle;

import main.MainClass;


public class MariaV3 extends Personnage{

	public MariaV3(int centerX, int centerY, Map map) {
		super(centerX,centerY,map,128,64);
	}

	public void initImages() {
			DROITE_1 = MainClass.imageLoad.catchImage("../ressources/images/persoMaria/maria_pas1d.png",persoHeight,persoWidth);
			GAUCHE_1 = MainClass.imageLoad.catchImage("../ressources/images/persoMaria/maria_pas1g.png",persoHeight,persoWidth);
			DROITE_2 = MainClass.imageLoad.catchImage("../ressources/images/persoMaria/maria_pas2d.png",persoHeight,persoWidth);
			GAUCHE_2 = MainClass.imageLoad.catchImage("../ressources/images/persoMaria/maria_pas2g.png",persoHeight,persoWidth);
			CHUTE = MainClass.imageLoad.catchImage("../ressources/images/persoMaria/maria_tombe.png",persoHeight,persoWidth);
			ATTENTE_D = MainClass.imageLoad.catchImage("../ressources/images/persoMaria/attented.png",persoHeight,persoWidth);
			ATTENTE_G= MainClass.imageLoad.catchImage("../ressources/images/persoMaria/attenteg.png",persoHeight,persoWidth);
			setImageCourante(ATTENTE_D);
			setCompteurPas(0);
	}
}
