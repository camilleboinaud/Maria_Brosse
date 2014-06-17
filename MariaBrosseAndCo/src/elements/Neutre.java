package elements;

public class Neutre extends Element {
	
	public Neutre(int x,int y,ImageLoad imageLoad) {
		super(x,y,64,64,TypeElt.NEUTRE,Couleur.NONE,imageLoad);
	}
	
	public void setPath() {
		this.path_image = "../ressources/images/neutre.png";
	}
}

