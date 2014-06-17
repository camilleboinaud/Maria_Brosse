package jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
* Une classe implémentant un chronomètre .
*
* @author Leviator
*
*/
public class Chrono {
private int heure = 0;
private int minute = 0;
private int seconde = 0;
private ActionListener listen_chro;
private Timer timer;

private String text;
public Chrono() {

text = heure + " : " + minute + " : " + seconde;

this.listen_chro = new Listen_Chrono();
this.timer = new Timer(1000, listen_chro);
timer.start();
}

public Chrono(int heure, int minute, int seconde) {
this.heure=heure;
this.minute = minute;
this.seconde = seconde;
text = heure + " : " + minute + " : " + seconde;
this.listen_chro = new Listen_Chrono();
this.timer = new Timer(1000, listen_chro);
timer.start();
}

/**
* @return the heure
*/
public int getHeure() {
return heure;
}

/**
* @return the minute
*/
public int getMinute() {
return minute;
}

/**
* @return the seconde
*/
public int getSeconde() {
return seconde;
}

/**
* @param heure the heure to set
*/
public void setHeure(int heure) {
this.heure = heure;
}

/**
* @param minute the minute to set
*/
public void setMinute(int minute) {
this.minute = minute;
}

/**
* @param seconde the seconde to set
*/
public void setSeconde(int seconde) {
this.seconde = seconde;
}

private String getText() {
return text;
}

private class Listen_Chrono implements ActionListener {
public void actionPerformed(ActionEvent event) {
if (seconde == 59) {
seconde = 0;
minute++;
}
if (minute == 59) {
minute = 0;
heure++;
}
seconde++;
text = (heure + " : " + minute + " : " + seconde);
}
}

public void reinitialisationTemps(){
this.seconde = 0;
this.minute = 0;
this.heure = 0;
}

public int getTempsEnSecondes() {
return heure*3600+minute*60+seconde;
}

public void draw(Graphics g, int x, int y){
g.setFont(new Font("Serif", Font.PLAIN, 72));
g.setColor(Color.WHITE);
g.drawString(text, x, y);
}

public void stop(){
timer.stop();
}

public void setTemps(int heure, int minute, int seconde){
this.heure = heure;
this.minute = minute;
this.seconde = seconde;
}
}