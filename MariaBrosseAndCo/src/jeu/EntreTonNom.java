package jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.MainClass;
import score.GestionPrenom;
import devintAPI.FenetreAbstraite;
import elements.ImageLoad;
import grid.ScreenManager;
//TODO but : qu'ils puissent rentrer leur nom à coté de leur score ... ca serait cool :D :D :D oh que oui !





import java.awt.event.TextListener;
import java.awt.event.ActionListener;

/**
 *
 * @author Leviathor
 *
 */
public class EntreTonNom extends FenetreAbstraite implements KeyListener{

	protected JTextField textField;
	private GestionPrenom gestionPrenom;
	private static ImageLoad imageLoad;
	

	public EntreTonNom() {
		super("Entre ton nom !");
		this.setForeground(Color.BLUE);
		ImageIcon icon = new ImageIcon ( Toolkit.getDefaultToolkit().getImage("../ressources/images/mariaTete.png"));
		super.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.gestionPrenom = new GestionPrenom();
		if(MainClass.frame!=null) MainClass.frame.dispose();
		MainClass.frame = this;
	}
	@Override
	protected void init() {
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		String imageURL = "../ressources/images/prenom.png";
		int width = (int)Math.round(1700*MainClass.ratioWidth);
		int height = (int)Math.round(650*MainClass.ratioHeight);
		ImageIcon ii = new ImageIcon(new ImageIcon(imageURL).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		JLabel labelImage = new JLabel(ii, SwingConstants.CENTER);
		add(BorderLayout.CENTER, labelImage);
		
		textField = new JTextField(50);
		this.addWindowListener(new WindowAdapter(){ 
			  public void windowOpened( WindowEvent e){ 
				  textField.requestFocus();
			  }
		});
		textField.setFont(new Font("Calibri",Font.PLAIN,(int)Math.round(200*MainClass.ratioHeight)));
		ToucheListener touches = new ToucheListener();
		textField.addKeyListener(touches);
		textField.addKeyListener(this);
		this.add(textField,BorderLayout.SOUTH);
		
		voix.playShortText("Bonjour ! Comment tu t'appelles ?");
	}

	@Override
	protected String wavAide() {
		return "Clique dans la zone de texte et entre ton nom .";
	}

	@Override
	public void changeColor() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String wavAccueil() {
		return "Bonjour ! Comment tu t'appelles ?";
	}

	@Override
	protected String wavRegleJeu() {
		return "Entre ton nom avec lè touche du clavié pui appuie sur ENTRER pour validé !";
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case KeyEvent.VK_ESCAPE :
			new MenuJeu("Maria Brosse");
			break;
		case KeyEvent.VK_ENTER:
			new Vitesse("Vitesse du jeu");
			String prenom = this.textField.getText();
			gestionPrenom.initPrenom(prenom);
			break;

		case KeyEvent.VK_F1:
			voix.stop();
			voix.playText(this.wavRegleJeu());
			break;

		case KeyEvent.VK_F4:
			voix.stop();
			voix.playText("Maria et ses amis veulent devenir plombié . Aide les à accomplir leur rêve en passant"
					+ "dans les tuyaux !");
			break;
		}
	}


	private class ZoneDeTexte extends JTextField {
		public ZoneDeTexte() {
			super();
			
		}
	}

	private class ToucheListener implements KeyListener {

		public void textValueChanged(TextEvent arg0) {
			String lecture = textField.getText();
			if(lecture !=null) {
				lecture = lecture.substring(lecture.length()-1,lecture.length()-1);
				voix.playShortText(lecture);
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {
			String lecture = textField.getText();
			if(lecture.length()>0) {
				lecture = lecture.substring(lecture.length()-1,lecture.length());
				if(lecture.equals("y"))
					voix.playText("i grèc");
				else if(lecture.equals("t"))
					voix.playText("té");
				else if (lecture.equals("s"))
					voix.playText("èsse");
				else
					voix.playText(lecture);
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}
	}
}