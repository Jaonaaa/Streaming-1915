package src.main;

import java.io.File;
import src.MultiMedia.Video;

public class Were {
    public static void main(String[] args) {
        try {
            //File file = new File("C:/Users/ITU/Desktop/Naina/StreamingApp 2/repository/C++.mp4");
           // Video vid = new Video();
          //  vid.start(file);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

// READING WAV FILE
/*
 * import java.io.*;
 * import java.util.Scanner;
 * import javax.sound.sampled.*;
 * 
 * public class Were {
 * 
 * public static void main (String[] args )
 * {
 * Scanner scan = new Scanner(System.in);
 * File fichier = new File("perfect.wav");
 * 
 * try
 * {
 * AudioInputStream audioSteam = AudioSystem.getAudioInputStream(fichier);
 * Clip clip = AudioSystem.getClip();
 * clip.open(audioSteam);
 * 
 * String reponse="";
 * 
 * while(!reponse.equals("QUIT"))
 * {
 * System.out.println("Start ,  Stop , Restart , Quit ");
 * System.out.println("Choose");
 * 
 * reponse = scan.next();
 * reponse = reponse.toUpperCase();
 * 
 * switch(reponse)
 * {
 * case("START"): clip.start();
 * break;
 * case("STOP"): clip.stop();
 * break;
 * case("RESTART"): clip.setMicrosecondPosition(0);
 * break;
 * case("QUIT"): clip.close();
 * break;
 * default: System.out.println("NOT A VALID COMMAND");
 * }
 * System.out.println("--------------------------------------");
 * }
 * }
 * catch (Exception err) {
 * System.out.println(err);
 * }
 * 
 * 
 * System.out.println("Exited");
 * }
 * }
 */