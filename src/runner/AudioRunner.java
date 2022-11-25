package src.runner;

import src.MultiMedia.Audio;
import java.io.*;

public class AudioRunner implements Runnable {

    String message;
    Audio audio;

    public AudioRunner(String msg, Audio audio) throws IOException {
        this.message = msg;
        this.audio = audio;
    }

    public void run() {
        try {
            System.out.println("Audio starting playing : "+message);
            this.audio.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}