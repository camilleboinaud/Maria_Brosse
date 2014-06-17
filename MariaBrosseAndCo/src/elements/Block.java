package elements;

public class Block extends Element {
	
	public Block(int x,int y,ImageLoad imageLoad) {
		super(x,y,64,64,TypeElt.BLOCK,Couleur.NONE,imageLoad);
	}
	
	public void setPath() {
		this.path_image = "../ressources/images/bloc_noir.png";
	}
}
