package elements;

import grid.Map;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import sons.AudioFile;
import sons.AudioWav;
import jeu.EntreDeux;
import main.MainClass;


public abstract class Personnage{
	protected int centerX, centerY;
	protected static final int MOVESPEED = (MainClass.speed == 1)?((MainClass.ratioWidth <= 0.5)?1:((MainClass.ratioWidth <=0.85)?2:2)):((MainClass.speed == 2)?((MainClass.ratioWidth <= 0.5)?3:((MainClass.ratioWidth <=0.85)?4:5)):((MainClass.ratioWidth <= 0.5)?5:((MainClass.ratioWidth <=0.85)?6:8)));
	protected static final int FALLSPEED = 1;
	protected static final int ENTERSPEED=1;
	public  static int persoHeight;
	public  static int persoWidth;
	public static int colHeight;
	public static int colWidth;
	protected int depart = 0;

	public static Image DROITE_1;
	public static Image GAUCHE_1;
	public static Image DROITE_2;
	public static Image GAUCHE_2;
	public static Image CHUTE;
	public static Image ATTENTE_D;
	public static Image ATTENTE_G;
	
	protected static Image imageCourante;
	
	protected int compteurPas;
	protected Element current;
	protected int speedX = 0, speedY = 0;

	protected boolean isFalling;
	protected boolean isMovingRight, isMovingLeft;
	protected boolean isEnteringLeft, isEnteringRight, isEnteringTop, isEnteringDown; 
	protected boolean sortieHaut,sortieBas,sortieGauche,sortieDroite;
	
	protected Map map;
	protected boolean levelcomplete;
	protected AudioWav audio;
	
	public Personnage(int centerX, int centerY, Map map,int persoHeight,int persoWidth) {
		this.audio = new AudioWav();
		Personnage.persoHeight = (int)Math.round(persoHeight*MainClass.ratioHeight);
		Personnage.persoWidth = (int) Math.round(persoWidth*MainClass.ratioWidth);
		this.centerX = centerX;
		this.centerY = centerY;
		this.map = map;
		this.current = map.getGrille().findElement(getCenterX(), getCenterY());
		this.levelcomplete = false;
		initImages();
		this.changeTuyau(current);
		
	}

	public abstract void initImages();

	public void update(){
		centerX += speedX;
		if(isEnteringRight){
			centerX+=ENTERSPEED;
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.getCenterX()>depart+(int)Math.round(MainClass.ratioWidth*100)){
				stopDroit();
				depart=0;
				changeTuyau(current);
				isEnteringRight=false;
			}
		}
		
		if(sortieDroite){
			centerX+=ENTERSPEED;
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(this.getCenterX()>depart+current.width/2){
				stopDroit();
				depart=0;
				setImageCourante(ATTENTE_D);
				sortieDroite=false;
				map.cantMove=false;
				actionChute();
			}
		}
		
		if(isEnteringDown){
			centerY+=ENTERSPEED;
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.getCenterY()>depart + (int)Math.round(MainClass.ratioHeight*current.height)){
				stopBas();
				depart=0;
				changeTuyau(current);
				isEnteringDown=false;				
			}
		}
		
		if(sortieBas){
			centerY-=ENTERSPEED;
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(this.getCenterY()<depart-2*current.height/3){
				stop();
				depart=0;
				setImageCourante(ATTENTE_D);
				sortieBas=false;
				map.cantMove=false;
			}
		}
		
		if(isEnteringTop){
			centerY-=ENTERSPEED;
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.getCenterY()<depart - 2*current.height/3){
				stop();
				depart=0;
				changeTuyau(current);
				isEnteringTop=false;
			}
		}
		
		if(sortieHaut){
			centerY+=ENTERSPEED;
			setImageCourante(CHUTE);
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.getCenterY()>depart+current.height-4){
				stopGauche();
				depart=0;
				sortieHaut=false;
				map.cantMove=false;
				actionChute();
			}
		}
		
		if(isEnteringLeft){
			centerX-=ENTERSPEED;
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.getCenterX()<depart-current.width){
				stopGauche();
				depart=0;
				changeTuyau(current);
				isEnteringLeft=false;
			}
		}
		if(sortieGauche){
			centerX-=ENTERSPEED;
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(this.getCenterX()<depart-current.width/2){
				stopGauche();
				depart=0;
				setImageCourante(ATTENTE_D);
				sortieGauche=false;
				map.cantMove=false;
				actionChute();
			}
		}
	
		if(isFalling){
			centerY+=speedY;
			setImageCourante(CHUTE);
			try {
				Thread.sleep(MainClass.speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.getCenterY()>=MainClass.screenHeight 
					|| collision(getCenterX(), getCenterY()+Personnage.persoHeight+2) 
					|| (getCenterX()>Personnage.persoWidth && collision(getCenterX()-Personnage.persoWidth, getCenterY()+Personnage.persoHeight+2)) 
				    || (getCenterX()<MainClass.screenWidth-Personnage.persoWidth && collision(getCenterX()+Personnage.persoWidth, getCenterY()+Personnage.persoHeight+2))){
				setImageCourante(ATTENTE_D);
				isFalling = false;
			}
		}
	}

	private boolean collision(int x, int y){
		Element e = map.getGrille().findElement(x, y);
		if(x>MainClass.screenWidth+Personnage.persoWidth/2 || x<=-Personnage.persoWidth) return true;
		
		if(e!=null && e.getBounds().intersects(getBounds()))
			return true;
		
		else return false;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(getCenterX(), getCenterY(),persoWidth, persoHeight);
	}
	
	public void actionDroite() {
			
		if(collision(getCenterX()+Personnage.persoWidth+1, getCenterY()+Personnage.persoHeight+2)){
			
			if(collision(getCenterX()+Personnage.persoWidth+1, getCenterY()+2) 
					&& collision(getCenterX()+Personnage.persoWidth+1, getCenterY()+ Personnage.persoHeight/2+2)){
				
				if(getCenterX()+Personnage.persoWidth/2<MainClass.screenWidth && !isEnteringRight){
					
					Element e1 = map.getGrille().findElement(getCenterX()+Personnage.persoWidth+1, getCenterY()+2);
					Element e2 = map.getGrille().findElement(getCenterX()+Personnage.persoWidth+1, getCenterY()+Personnage.persoHeight/2+2);
					
					if (e1!=null && e2!=null){
						if (e1.getTypeElt()==TypeElt.GAUCHE && e2.getTypeElt()==TypeElt.NEUTRE){
							map.cantMove = true;
							isMovingRight = false;
							stop();
							entreTuyau(e1);
						} 
						else if(e1.getTypeElt()==TypeElt.NEUTRE && e2.getTypeElt()==TypeElt.NEUTRE){
							Element e3 = map.getGrille().findElement(getCenterX()+1, getCenterY()+2);
							if(e3!=null){
								if(e3.getTypeElt()==TypeElt.GAUCHE)
									map.cantMove = true;
									isMovingRight = false;
									stop();
									entreTuyau(e3);
							} else this.sortieTuyau();
						}
					}
					else {
						this.sortieTuyau();
					}
				} 
			}
		}
		
		if(collision(getCenterX()-Personnage.persoWidth/2, getCenterY()+Personnage.persoHeight+2)
				&& !collision(getCenterX()+3*Personnage.persoWidth/2, getCenterY()+2)
				&& !collision(getCenterX()+3*Personnage.persoWidth/2, getCenterY()+Personnage.persoWidth/2+2)
				&& !collision(getCenterX()+Personnage.persoWidth, getCenterY()+2)
				&& !collision(getCenterX()+Personnage.persoWidth, getCenterY()+Personnage.persoWidth/2+2)){
			
			isMovingRight = true;
			isMovingLeft = false;
			speedX = MOVESPEED;			
			
			if(getCompteurPas()%12<6)
				setImageCourante(DROITE_1);
			
			else setImageCourante(DROITE_2);
			
			setCompteurPas(getCompteurPas() + 1);
		}
		
		if(!collision(getCenterX()-(int)Math.round(((MainClass.ratioWidth<=0.5)?30:(MainClass.ratioWidth==1)?32:31)*MainClass.ratioWidth), getCenterY()+Personnage.persoHeight+(int)Math.round(2*MainClass.ratioHeight)) 
				&& !collision(getCenterX()+Personnage.persoWidth, getCenterY()+(int)Math.round(2*MainClass.ratioHeight))){
			
			stopDroit();
			setImageCourante(CHUTE);
			actionChute();
		}
	}

	public void actionGauche() {
		
		if(collision(getCenterX(), getCenterY()+Personnage.persoHeight+2)){
			
			if((collision(getCenterX()-Personnage.persoWidth, getCenterY()+2)
					&& collision(getCenterX()-Personnage.persoWidth, getCenterY()+(Personnage.persoHeight/2)+2))){
				
				if(getCenterX()>=0 && !isEnteringLeft){

					Element e1 = map.getGrille().findElement(getCenterX()-3*Personnage.persoWidth+1, getCenterY()+ 2);
					Element e2 = map.getGrille().findElement(getCenterX()-3*Personnage.persoWidth+1, getCenterY()+(Personnage.persoHeight/2)+2);
					
					if (e1!=null && e2!=null){
						
						if (e1.typeElt==TypeElt.DROITE && e2.typeElt==TypeElt.NEUTRE){
							map.cantMove = true;
							isMovingLeft = false;
							stop();
							entreTuyau(e1);
						}
					} 
				}
			} 
		}
		if((collision(getCenterX()+(int)Math.round(((MainClass.ratioWidth<=0.5)?29:(MainClass.ratioWidth==1)?31:30)*MainClass.ratioWidth),getCenterY()+Personnage.persoHeight+2) 
				|| (getCenterX()>MainClass.screenWidth-Personnage.persoWidth && collision(getCenterX(),getCenterY()+Personnage.persoHeight+2)))
				&& !collision(getCenterX()-Personnage.persoWidth, getCenterY()+2)
				&& !collision(getCenterX()-Personnage.persoWidth, getCenterY()+(Personnage.persoHeight/2)+2)
				&& !collision(getCenterX()-Personnage.persoWidth/2, getCenterY()+2)
				&& !collision(getCenterX()-Personnage.persoWidth/2, getCenterY()+(Personnage.persoHeight/2)+2)){
		
			isMovingRight = false;
			isMovingLeft = true;
			speedX = -MOVESPEED;
			
			if(getCompteurPas()%12<6)
				setImageCourante(GAUCHE_1);
			
			else setImageCourante(GAUCHE_2);	
			
			setCompteurPas(getCompteurPas() + 1);
		}
		
		if(!collision(getCenterX()+(int)Math.round(((MainClass.ratioWidth<=0.5)?30:(MainClass.ratioWidth==1)?32:31)*MainClass.ratioWidth), getCenterY()+Personnage.persoHeight+10) 
				&& !collision(getCenterX(), getCenterY()+Personnage.persoHeight+10)){
			
			stopGauche();
			setImageCourante(CHUTE);
			actionChute();
		}
	}

	public void actionBas() {
		if(collision(getCenterX()-Personnage.persoWidth/2, getCenterY()+Personnage.persoHeight+2)){
			Element e = map.getGrille().findElement(getCenterX()-Personnage.persoWidth/2, getCenterY()+Personnage.persoHeight+2);
			if(e!=null){
				if(e.typeElt==TypeElt.HAUT){
					depart=getCenterY();
					entreTuyau(map.getGrille().findElement(getCenterX()-Personnage.persoWidth/2, getCenterY()+Personnage.persoHeight+2));
				}
			} else sortieTuyau();
		}
	}
	
	public void actionHaut() {
		if(collision(getCenterX()-Personnage.persoWidth/2, getCenterY()-(3*Personnage.persoHeight/2))){
			if(map.getGrille().findElement(getCenterX()-Personnage.persoWidth/2, getCenterY()-(3*Personnage.persoHeight/2))!=null){
				if(map.getGrille().findElement(getCenterX()-Personnage.persoWidth/2, getCenterY()-(3*Personnage.persoHeight/2)).typeElt==TypeElt.BAS ){
					depart=getCenterY();
					entreTuyau(map.getGrille().findElement(getCenterX()-Personnage.persoWidth/2, getCenterY()-(3*Personnage.persoHeight/2)));
				} 
			} else sortieTuyau();
		}	
	}

	public void actionChute(){
			speedY=FALLSPEED;
			setImageCourante(CHUTE);
			isFalling = true;
	}
	

	public void changeTuyau(Element elt){
		if(elt!=null && elt.getCouleur()!=Couleur.NONE && elt.getCouleur()!=Couleur.SORTIE 
				&& elt.getCouleur()!=Couleur.ENTREE){
			ArrayList<Element> elts = map.getGrille().listColor(elt.getCouleur());
			for(Element e:elts){
				if(!e.isInside()){
					this.current=e;
					if(e.typeElt==TypeElt.BAS || e.typeElt==TypeElt.HAUT)
						setCenterX(e.getX()+(e.getWidth()/2-(Personnage.persoWidth/2)));
					else if (e.typeElt==TypeElt.GAUCHE) 
						setCenterX(e.getX()+(e.getWidth()/2)-Personnage.persoWidth);
					else 
						setCenterX(e.getX()+(e.getWidth()/2));
					setCenterY(e.getY()+1);
				}
			}
			for(Element e:elts){
				if(e.isInside()) e.inside=false;
			}
			sortieTuyau();
		}
		else if(elt!=null && elt.getCouleur()==Couleur.SORTIE){
			MainClass.gestionScore.ecritureScore();
			AudioWav.stop();
			map.quit = false;
			new EntreDeux(map.niveauInit);
			map = null;
		}
		else if(elt!=null && elt.getCouleur()==Couleur.ENTREE){
			this.current=elt;
			if(elt.typeElt==TypeElt.BAS || elt.typeElt==TypeElt.HAUT)
				setCenterX(elt.getX()+(elt.getWidth()/2-(Personnage.persoWidth/2)));
			else if (elt.typeElt==TypeElt.GAUCHE) 
				setCenterX(elt.getX()+(elt.getWidth()/2)-Personnage.persoWidth);
			else 
				setCenterX(elt.getX()+(elt.getWidth()/2));
			setCenterY(elt.getY()+1);
			sortieTuyau();
		}
	}
	
	public void sortieTuyau(){
		if(!current.inside){
			if(current.typeElt==TypeElt.BAS || current.typeElt==TypeElt.HAUT)
				setCenterX(current.getX()+(current.getWidth()/2-(Personnage.persoWidth/2)));
			else if (current.typeElt==TypeElt.GAUCHE) 
				setCenterX(current.getX()+(current.getWidth()/2)-Personnage.persoWidth);
			else 
				setCenterX(current.getX()+(current.getWidth()/2));
			setCenterY(current.getY()+1);
		}
		
		if(current.getTypeElt()==TypeElt.BAS){ 
			stop();
			depart=getCenterY();
			this.sortieHaut=true;
		}
		else if(current.getTypeElt()==TypeElt.HAUT){
			stop();
			depart=getCenterY();
			this.sortieBas=true;
		}
		else if(current.getTypeElt()==TypeElt.GAUCHE){
			stop();
			depart=getCenterX();
			this.sortieGauche=true;
		}
		else if(current.getTypeElt()==TypeElt.DROITE){
			stop();
			depart=getCenterX();
			this.sortieDroite=true;
		}
	}
	
	public void entreTuyau(Element elt){
		AudioWav.playTuyau();
		if(elt.getTypeElt() == TypeElt.DROITE){
			isEnteringLeft=true;
			depart=getCenterX();
		} else if(elt.getTypeElt() == TypeElt.GAUCHE){
			isEnteringRight=true;
			depart=getCenterX();
		} else if(elt.getTypeElt() == TypeElt.BAS){
			isEnteringTop=true;
			depart=getCenterY();
		} else if(elt.getTypeElt() == TypeElt.HAUT){
			isEnteringDown=true;
			depart=getCenterY();
		}
		elt.inside=true;
		map.cantMove=true;
		this.current = elt;
	}

	public void stopDroit(){
		isMovingRight = false;
		map.cantMove = false;
		stop();
	}
	public void stopGauche(){
		isMovingLeft = false;
		map.cantMove = false;
		stop();
	}
	public void stopBas(){
		isMovingRight = false;
		isMovingLeft = false;
		stop();
	}
	public void stop(){
		
		isMovingRight = false;
		isMovingLeft = false;
		map.cantMove = false;
		
		if(!isMovingLeft && !isMovingRight){
			speedX = 0;
		}
		if(!isMovingLeft && isMovingRight){
			actionGauche();
		}
		if(isMovingLeft && !isMovingRight){
			actionDroite();
		}
	}
	
	public int getCenterX() {
		return (int)Math.round(centerX*MainClass.ratioWidth);
	}
	

	public int getCenterY() {
		return (int)Math.round(centerY*MainClass.ratioHeight);
	}
	
	public void setCenterX(int centerX){
		this.centerX = (int)Math.round(centerX/MainClass.ratioWidth);
	}
	
	public void setCenterY(int centerY){
		this.centerY = (int)Math.round(centerY/MainClass.ratioHeight);
	}
	
	public Image getImageCourante() {
		return imageCourante;
	}
	public void setImageCourante(Image imageCourante) {
		Personnage.imageCourante = imageCourante;
	}

	public int getCompteurPas() {
		return compteurPas;
	}
	public void setCompteurPas(int compteurPas) {
		this.compteurPas = compteurPas;
	}
	public Map getMap() {
		return map;
	}

	
	public boolean isAnAction(){
		if(this.isEnteringDown || this.isEnteringLeft || this.isEnteringRight || this.isEnteringTop
				|| this.sortieBas || this.sortieDroite || this.sortieGauche || this.sortieHaut)
			return true;
		return false;
	}


}
