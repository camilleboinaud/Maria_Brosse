package sons;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class AudioWav {

    private static AudioClip FINAL;
    private static AudioClip LEVEL1;
    private static AudioClip LEVEL2;
    private static AudioClip LEVEL3;
    private static AudioClip LEVEL4;
    private static AudioClip s2;

    private static URL uF;
    private static URL uA;
    private static URL uB;
    private static URL uC;
    private static URL uD;
    private static URL u2;
    
    public static void loadSounds(){
		try {
			u2 = new URL("file:../ressources/sons/TUYAU.wav");
			uF = new URL("file:../ressources/sons/level_complete.wav");
			uA = new URL("file:../ressources/sons/level1.wav");
			uB = new URL("file:../ressources/sons/level2.wav");
			uC = new URL("file:../ressources/sons/level3.wav");
			uD = new URL("file:../ressources/sons/level4.wav");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		s2 = Applet.newAudioClip(u2);
		FINAL = Applet.newAudioClip(uF);
		LEVEL1 = Applet.newAudioClip(uA);
		LEVEL2 = Applet.newAudioClip(uB);
		LEVEL3 = Applet.newAudioClip(uC);
		LEVEL4 = Applet.newAudioClip(uD);


    }
    
/** lance le son */
    public static void playSound(AudioFile file) {
    	try {
			if(file == AudioFile.FINAL) FINAL.loop();
			if(file == AudioFile.LEVEL1) LEVEL1.loop();
			if(file == AudioFile.LEVEL2) LEVEL2.loop();
			if(file == AudioFile.LEVEL3) LEVEL3.loop();
			if(file == AudioFile.LEVEL4) LEVEL4.loop();			
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /** lance le son */
    public static void playTuyau() {
    	try {	
			s2.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
/** arrete le son */
    public static void stop() {
    	try{
    		if(s2!=null) s2.stop();
    		if(FINAL!=null) FINAL.stop();
    		if(LEVEL1 != null) LEVEL1.stop();
    		if(LEVEL2 != null) LEVEL2.stop();
    		if(LEVEL3 != null) LEVEL3.stop();
    		if(LEVEL4 != null) LEVEL4.stop();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
   