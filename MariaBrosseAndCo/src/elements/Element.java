package elements;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import main.MainClass;

//concernant le booleen passage, si il est à false, il y a collision avec Maria, sinon Maria peut passer dessous .

public abstract class Element implements ImageObserver{
	
	protected String path_image;//le path de l'image de l'élément .
	protected TypeElt typeElt;
	protected Couleur couleur;


	protected int x;//abscisse en PIXEL
	protected int y;//ordonnee en PIXEL
	protected int height;
	protected int width;
	protected boolean inside;
	private Image image;
	private ImageLoad imageLoad;

/**
 * le constructeur par défaut .
 */
	public Element() {
		super();
	}
	public Element(int x,int y, int height, int width,TypeElt typeElt,Couleur color, ImageLoad imageLoad) {
		super();
		this.x = (int) Math.round(x*MainClass.ratioWidth);
		this.y = (int) Math.round(y*MainClass.ratioHeight);
		this.width = (int)Math.round(width*MainClass.ratioWidth);
		this.height = (int)Math.round(height*MainClass.ratioHeight);
		this.typeElt=typeElt;
		this.couleur=color;
		this.imageLoad = imageLoad;
	}

/**
 * permet de dessiner l'élément aux coordonnées x y .
 * @param g
 */
	public void draw(Graphics g) {
		setPath();
		image = imageLoad.catchImage(path_image, height, width);
		g.drawImage(image,x,y,width,height,this);
	}

	@Override
	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,
			int arg4, int arg5) {
		return true;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return y;
	}
	
	/**
	 * Méthode qiu va permettre de définir le path . Abstract car par exemple pour un tuyau, y a plusieurs couleurs
	 * donc plusieurs images ...à la diférence des blocs qui sont tous à partir de la même image .
	 */
	abstract void setPath();
	public String getPath_image() {
		return path_image;
	}

	public TypeElt getTypeElt() {
		return typeElt;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public Couleur getCouleur() {
		return couleur;
	}
	public boolean isInside() {
		return inside;
	}
	public void setInside(boolean inside) {
		this.inside = inside;
	}
	
	
	
	
	
	
}
