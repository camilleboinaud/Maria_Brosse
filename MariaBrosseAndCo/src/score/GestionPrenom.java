package score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestionPrenom {
	
	public String recupererContenuPrenom(int nb_ligne) {
		String chemin = ".." + File.separator + "ressources" + File.separator + "prenom.txt";
		String contenu = "";
		try {
			FileReader r = new FileReader(chemin);
			BufferedReader lecteur = new BufferedReader(r);
			for(int i = 1;i<=nb_ligne;i++){
				String l_tmp = lecteur.readLine();
				contenu = contenu +l_tmp+"\n";
			}
			r.close();
			lecteur.close();
		}
		catch(IOException e){
			System.out.println("probleme");
		}
		return contenu;
	}
	
	public String recupererDerniereLigne() {
		String chemin = ".." + File.separator + "ressources" + File.separator + "prenom.txt";
		String ligne = "";
		try {
			FileReader r = new FileReader(chemin);
			BufferedReader lecteur = new BufferedReader(r);
			String l_tmp = "";
			while((l_tmp = lecteur.readLine())!=null){
				ligne = l_tmp;
			}
			r.close();
			lecteur.close();
		}
		catch(IOException e){
			System.out.println("probleme");
		}
		return ligne;
	}
	public int recupererNombreDeLigne() {
		String chemin = ".." + File.separator + "ressources" + File.separator + "prenom.txt";
		int nb_ligne = 0;
		try {
			FileReader r = new FileReader(chemin);
			BufferedReader lecteur = new BufferedReader(r);
			while(lecteur.readLine()!=null){
				nb_ligne++;
			}
			r.close();
			lecteur.close();
		}
		catch(IOException e){
			System.out.println("probleme");
		}
		return nb_ligne;
	}	
	
	public void initPrenom(String prenom) {
		String chemin = ".." + File.separator + "ressources" + File.separator + "prenom.txt";
		String contenu = this.recupererContenuPrenom(recupererNombreDeLigne());
		try {
			FileWriter w = new FileWriter(chemin);
			w.write(contenu+prenom+"\n");
			w.close();
		}
		catch(IOException e){
			System.out.println("le fichier de score n'a pas été trouvé");
		}
	}
}
