package src.MultiMedia;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InterruptedIOException;
import java.io.File;
import javazoom.jl.player.*;

public class Audio extends Multimedia {

  File myFile = new File("./repository/test.mp3");
  Player myAudio;

  public Audio() {
    try {
      BufferedInputStream reader = new BufferedInputStream(new FileInputStream("./repository/test.mp3"));
    this.myAudio = new Player(reader);
    } catch (Exception e) 
    {
      System.out.println(e);
    }
  }

  public Audio(File file) {
    this.myFile = file;
  }

  public void play() throws Exception {
    // Reading MP3
    BufferedInputStream reader = new BufferedInputStream(new FileInputStream(this.myFile));
    this.myAudio = new Player(reader);
    myAudio.play();
  }

  public void stop() {
    if (this.myAudio != null) {
      myAudio.close();
    }
  }

  public void pause() throws InterruptedIOException, InterruptedException {
    if (this.myAudio != null) {
      myAudio.wait();
      ;
    }
  }

  /**
   * @return the myFile
   */
  public File getMyFile() {
    return myFile;
  }

  /**
   * @param myFile the myFile to set
   */
  public void setMyFile(File myFile) {
    this.myFile = myFile;
  }

  /**
   * @return the myAudio
   */
  public Player getMyAudio() {
    return myAudio;
  }

  /**
   * @param myAudio the myAudio to set
   */
  public void setMyAudio(Player myAudio) {
    this.myAudio = myAudio;
  }

}
