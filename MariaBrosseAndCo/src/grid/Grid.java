package grid;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import main.MainClass;
import elements.Block;
import elements.Couleur;
import elements.Element;
import elements.ImageLoad;
import elements.Neutre;
import elements.TuyauBas;
import elements.TuyauDroite;
import elements.TuyauGauche;
import elements.TuyauHaut;

public class Grid {

	private Element[][] grille;
	private final static String COORDONNEES= "../ressources/initPos.txt";
	private String path_map;
	public ArrayList<Integer> initX;
	public ArrayList<Integer> initY;
	private ImageLoad imageLoad;

	public Grid(File file, ImageLoad imageLoad){
		this.imageLoad = imageLoad;
		this.grille = new Element[25][14];
		this.initX = new ArrayList<Integer>();
		this.initY = new ArrayList<Integer>();
		this.initGrille(recupTexteMap(file));
		this.initPosMap();
	}
	
	public String recupTexteMap(File file) {
		String txt="";
		try{
			FileReader r = new FileReader(file);
			BufferedReader lecteur = new BufferedReader(r);
			String ligne = "";
			try{
				while((ligne = lecteur.readLine())!=null){
					txt = txt+ligne+"\n";
				}
			}
			catch(IOException e){
				System.out.println("Problème à la lecture d'une ligne du fichier :"+this.path_map);
			}
		}
		catch(FileNotFoundException e){
			MainClass.resetLevel(-1);
		}
		return txt;
	}
	public void initPosMap() {
		String txt="";
		try{
			FileReader r = new FileReader(new File(COORDONNEES));
			BufferedReader lecteur = new BufferedReader(r);
			String ligne = "";
			try{
				while((ligne = lecteur.readLine())!=null){
					txt = txt+ligne+"\n";
				}
			}
			catch(IOException e){
				System.out.println("Problème à la lecture d'une ligne du fichier :"+this.path_map);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Le fichier "+this.path_map+" n'est pas trouvé.");
		}
		while(!txt.isEmpty()){
			int depart=0;
			int fin=0;
			while(txt.charAt(fin)!=',') fin++;
			this.initX.add(Integer.parseInt(txt.substring(depart,fin)));
			txt = txt.replaceFirst(txt.substring(depart,fin+1), "");
			depart=0;
			fin = 0;
			while(txt.charAt(fin)!='\n') fin++;
			this.initY.add(Integer.parseInt(txt.substring(depart,fin)));
			txt = txt.replaceFirst(txt.substring(depart,fin+1), "");
		}
	}
	
	public void initGrille(String texte) {
		String[] tableau = new String[365];//va contenir les String correspondant aux éléments (du genre 00,11,etc)
		int index=0;//l'index de lecture du fichier .
		for(int i=0;i<364;i++){//i est l'index du tableau où on écrit une des chaînes de caractère .
			if(texte.substring(index, index+1).equals("\n")){
				tableau[i] = "\n";
				index++;
			}
			else{
				String s = texte.substring(index, index+2);
				tableau[i] = s;
				index=index+2;
			}
		}
		int index_j=0;
		for(int i=0;i<364;i++){
			String s = tableau[i];
			int index_i = i%26;
			switch(s){
			case "00":
				//bloc noir
				Block bloc = new Block(index_i*64, index_j*64, imageLoad);
				this.grille[index_i][index_j]=bloc;
				break;
			case "NN"://bloc noir
				Neutre neutre = new Neutre(index_i*64, index_j*64, imageLoad);
				this.grille[index_i][index_j]=neutre;
				break;
			case "11"://élément vide : aucune image n'est affichée, on voit l'image de fond .
				grille[index_i][index_j]=null;
				break;
				
			case "RD"://tuyau rouge dont l'entrée est vers le bas .
				TuyauDroite tuyauD = new TuyauDroite(index_i*64, index_j*64,Couleur.ROUGE, imageLoad);
				this.grille[index_i][index_j]=tuyauD;
				break;
			case "CD"://tuyau rouge dont l'entrée est vers le bas .
				TuyauDroite tuyau1D = new TuyauDroite(index_i*64, index_j*64,Couleur.BLEU_CLAIR, imageLoad);
				this.grille[index_i][index_j]=tuyau1D;
				break;
			case "BD"://tuyau rouge dont l'entrée est vers le bas .
				TuyauDroite tuyau2D = new TuyauDroite(index_i*64, index_j*64,Couleur.BLEU_FONCE, imageLoad);
				this.grille[index_i][index_j]=tuyau2D;
				break;
			case "JD"://tuyau rouge dont l'entrée est vers le bas .
				TuyauDroite tuyau3D = new TuyauDroite(index_i*64, index_j*64,Couleur.JAUNE, imageLoad);
				this.grille[index_i][index_j]=tuyau3D;
				break;
			case "GD"://tuyau rouge dont l'entrée est vers le bas .
				TuyauDroite tuyau5D = new TuyauDroite(index_i*64, index_j*64,Couleur.VERT, imageLoad);
				this.grille[index_i][index_j]=tuyau5D;
				break;
			case "VD"://tuyau rouge dont l'entrée est vers le bas .
				TuyauDroite tuyau6D = new TuyauDroite(index_i*64, index_j*64,Couleur.VIOLET, imageLoad);
				this.grille[index_i][index_j]=tuyau6D;
				break;
			case "gD"://tuyau rouge dont l'entrée est vers le bas .
				TuyauDroite tuyau7 = new TuyauDroite(index_i*64, index_j*64,Couleur.GRIS, imageLoad);
				this.grille[index_i][index_j]=tuyau7;
				break;
			case "MD"://tuyau rouge dont l'entrée est vers le bas .
				TuyauDroite tuyau8 = new TuyauDroite(index_i*64, index_j*64,Couleur.MARRON, imageLoad);
				this.grille[index_i][index_j]=tuyau8;
				break;
			case "SD"://tuyau de sortie dont l'entrée est vers le haut .
				TuyauDroite sortieD = new TuyauDroite(index_i*64, index_j*64,Couleur.SORTIE, imageLoad);
				this.grille[index_i][index_j]=sortieD;
				break;
			case "ED"://tuyau de sortie dont l'entrée est vers le haut .
				TuyauDroite entreeD = new TuyauDroite(index_i*64, index_j*64,Couleur.ENTREE, imageLoad);
				this.grille[index_i][index_j]=entreeD;
				break;
				
			case "RG"://tuyau rouge dont l'entrée est vers le bas .
				TuyauGauche tuyauG = new TuyauGauche(index_i*64, index_j*64,Couleur.ROUGE, imageLoad);
				this.grille[index_i][index_j]=tuyauG;
				break;
			case "CG"://tuyau rouge dont l'entrée est vers le bas .
				TuyauGauche tuyau1G = new TuyauGauche(index_i*64, index_j*64,Couleur.BLEU_CLAIR, imageLoad);
				this.grille[index_i][index_j]=tuyau1G;
				break;
			case "BG"://tuyau rouge dont l'entrée est vers le bas .
				TuyauGauche tuyau2G = new TuyauGauche(index_i*64, index_j*64,Couleur.BLEU_FONCE, imageLoad);
				this.grille[index_i][index_j]=tuyau2G;
				break;
			case "JG"://tuyau rouge dont l'entrée est vers le bas .
				TuyauGauche tuyau3G = new TuyauGauche(index_i*64, index_j*64,Couleur.JAUNE, imageLoad);
				this.grille[index_i][index_j]=tuyau3G;
				break;
			case "GG"://tuyau rouge dont l'entrée est vers le bas .
				TuyauGauche tuyau5G = new TuyauGauche(index_i*64, index_j*64,Couleur.VERT, imageLoad);
				this.grille[index_i][index_j]=tuyau5G;
				break;
			case "VG"://tuyau rouge dont l'entrée est vers le bas .
				TuyauGauche tuyau6G = new TuyauGauche(index_i*64, index_j*64,Couleur.VIOLET, imageLoad);
				this.grille[index_i][index_j]=tuyau6G;
				break;
			case "gG"://tuyau rouge dont l'entrée est vers le bas .
				TuyauGauche g7 = new TuyauGauche(index_i*64, index_j*64,Couleur.GRIS, imageLoad);
				this.grille[index_i][index_j]=g7;
				break;
			case "MG"://tuyau rouge dont l'entrée est vers le bas .
				TuyauGauche m8 = new TuyauGauche(index_i*64, index_j*64,Couleur.MARRON, imageLoad);
				this.grille[index_i][index_j]=m8;
				break;
			case "SG"://tuyau de sortie dont l'entrée est vers le haut .
				TuyauGauche sortieG = new TuyauGauche(index_i*64, index_j*64,Couleur.SORTIE, imageLoad);
				this.grille[index_i][index_j]=sortieG;
				break;
			case "EG"://tuyau de sortie dont l'entrée est vers le haut .
				TuyauGauche entreeG = new TuyauGauche(index_i*64, index_j*64,Couleur.ENTREE, imageLoad);
				this.grille[index_i][index_j]=entreeG;
				break;
				
			case "RH"://tuyau rouge dont l'entrée est vers le bas .
				TuyauHaut tuyauH = new TuyauHaut(index_i*64, index_j*64,Couleur.ROUGE, imageLoad);
				this.grille[index_i][index_j]=tuyauH;
				break;
			case "CH"://tuyau rouge dont l'entrée est vers le bas .
				TuyauHaut tuyau1H = new TuyauHaut(index_i*64, index_j*64,Couleur.BLEU_CLAIR, imageLoad);
				this.grille[index_i][index_j]=tuyau1H;
				break;
			case "BH"://tuyau rouge dont l'entrée est vers le bas .
				TuyauHaut tuyau2H = new TuyauHaut(index_i*64, index_j*64,Couleur.BLEU_FONCE, imageLoad);
				this.grille[index_i][index_j]=tuyau2H;
				break;
			case "JH"://tuyau rouge dont l'entrée est vers le bas .
				TuyauHaut tuyau3H = new TuyauHaut(index_i*64, index_j*64,Couleur.JAUNE, imageLoad);
				this.grille[index_i][index_j]=tuyau3H;
				break;
			case "GH"://tuyau rouge dont l'entrée est vers le bas .
				TuyauHaut tuyau5H = new TuyauHaut(index_i*64, index_j*64,Couleur.VERT, imageLoad);
				this.grille[index_i][index_j]=tuyau5H;
				break;
			case "VH"://tuyau rouge dont l'entrée est vers le bas .
				TuyauHaut tuyau6H = new TuyauHaut(index_i*64, index_j*64,Couleur.VIOLET, imageLoad);
				this.grille[index_i][index_j]=tuyau6H;
				break;
			case "gH"://tuyau rouge dont l'entrée est vers le bas .
				TuyauHaut gg = new TuyauHaut(index_i*64, index_j*64,Couleur.GRIS, imageLoad);
				this.grille[index_i][index_j]=gg;
				break;
			case "MH"://tuyau rouge dont l'entrée est vers le bas .
				TuyauHaut tt = new TuyauHaut(index_i*64, index_j*64,Couleur.MARRON, imageLoad);
				this.grille[index_i][index_j]=tt;
				break;
			case "SH"://tuyau de sortie dont l'entrée est vers le haut .
				TuyauHaut sortieH = new TuyauHaut(index_i*64, index_j*64,Couleur.SORTIE, imageLoad);
				this.grille[index_i][index_j]=sortieH;
				break;
			case "EH"://tuyau de sortie dont l'entrée est vers le haut .
				TuyauHaut entreeH = new TuyauHaut(index_i*64, index_j*64,Couleur.ENTREE, imageLoad);
				this.grille[index_i][index_j]=entreeH;
				break;

			case "RB"://tuyau rouge dont l'entrée est vers le bas .
				TuyauBas tuyau = new TuyauBas(index_i*64, index_j*64,Couleur.ROUGE, imageLoad);
				this.grille[index_i][index_j]=tuyau;
				break;
			case "CB"://tuyau rouge dont l'entrée est vers le bas .
				TuyauBas tuyau1 = new TuyauBas(index_i*64, index_j*64,Couleur.BLEU_CLAIR, imageLoad);
				this.grille[index_i][index_j]=tuyau1;
				break;
			case "BB"://tuyau rouge dont l'entrée est vers le bas .
				TuyauBas tuyau2 = new TuyauBas(index_i*64, index_j*64,Couleur.BLEU_FONCE, imageLoad);
				this.grille[index_i][index_j]=tuyau2;
				break;
			case "JB"://tuyau rouge dont l'entrée est vers le bas .
				TuyauBas tuyau3 = new TuyauBas(index_i*64, index_j*64,Couleur.JAUNE, imageLoad);
				this.grille[index_i][index_j]=tuyau3;
				break;
			case "GB"://tuyau rouge dont l'entrée est vers le bas .
				TuyauBas tuyau5 = new TuyauBas(index_i*64, index_j*64,Couleur.VERT, imageLoad);
				this.grille[index_i][index_j]=tuyau5;
				break;
			case "VB"://tuyau rouge dont l'entrée est vers le bas .
				TuyauBas tuyau6 = new TuyauBas(index_i*64, index_j*64,Couleur.VIOLET, imageLoad);
				this.grille[index_i][index_j]=tuyau6;
				break;
			case "gB"://tuyau gris dont l'entrée est vers le bas .
				TuyauBas ff = new TuyauBas(index_i*64, index_j*64,Couleur.GRIS, imageLoad);
				this.grille[index_i][index_j]=ff;
				break;
			case "MB"://tuyau marron dont l'entrée est vers le bas .
				TuyauBas bb = new TuyauBas(index_i*64, index_j*64,Couleur.MARRON, imageLoad);
				this.grille[index_i][index_j]=bb;
				break;
			case "SB"://tuyau de sortie dont l'entrée est vers le haut .
				TuyauBas sortie = new TuyauBas(index_i*64, index_j*64,Couleur.SORTIE, imageLoad);
				this.grille[index_i][index_j]=sortie;
				break;
			case "EB"://tuyau de sortie dont l'entrée est vers le haut .
				TuyauBas entree = new TuyauBas(index_i*64, index_j*64,Couleur.ENTREE, imageLoad);
				this.grille[index_i][index_j]=entree;
				break;
			case "\n":
				index_j++;
				break;
			}
		}
	}
	
	public Element findElement(int x, int y){
		if(x<0) x = 0;
		if((int)Math.round(x/(MainClass.ratioWidth*64))>=25 || (int)Math.round(y/(MainClass.ratioHeight*64))>=14) return null;
		return grille[(int)Math.round(x/(MainClass.ratioWidth*64))][(int)Math.round(y/(MainClass.ratioHeight*64))];
	}
	
	public ArrayList<Element> listColor(Couleur color){
		ArrayList<Element> elts = new ArrayList<Element>();
		for(int i=0; i<25; i++){
			for(int j=0; j<14; j++){
				if(this.grille[i][j]!=null){
					if(this.grille[i][j].getCouleur()==color){
						elts.add(this.grille[i][j]);
					}
				}
			}
		}
		return elts;
	}
	
	public void draw(Graphics g2d){
		for(int i = 0;i<25;i++){
			for(int j = 0;j<14;j++) {
				Element element = getGrille()[i][j];
				if(element!=null){
					element.draw(g2d);
				}
			}
		}
	}
	
	public Element[][] getGrille() {
		return grille;
	}

	public String getPath_map() {
		return path_map;
	}
	
}
