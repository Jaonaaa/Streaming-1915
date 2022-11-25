package src.MultiMedia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import src.runner.VideoRunner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Video extends Application {

    File myFile;
    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    Stage primaryStage;
    Button btnPlayAndPause;
    Pane pane;
    Scene scene;

    public double RDT(double he, double heThis, double me) {
        return (me * heThis) / he;
    }

    public void getTheFile() {
        FileChooser fileChoser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Mp4 only ", "*.mp4");
        fileChoser.getExtensionFilters().add(filter);
        this.myFile = fileChoser.showOpenDialog(null);
    }

    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        String list = this.getParameters().getRaw().get(0);
        this.myFile = new File(list);
        String path = this.myFile.toURI().toString();
        if (path != null) {
            // Instantiating Media class
            this.media = new Media(path);
            // Instantiating MediaPlayer class
            this.mediaPlayer = new MediaPlayer(media);
            this.mediaPlayer.setOnReady(new VideoRunner(this));
        }

    }

    public byte[] getHisByte(File file) throws Exception {
        byte[] bytes = null;
        try {
            Path pa = Paths.get(file.getAbsolutePath());
            bytes = Files.readAllBytes(pa);
            System.out.println(("Bytes of the file : " + bytes.length));
        } catch (Exception e) {
            throw e;
        }
        return bytes;
    }

    public void start(File file) {
        launch(file.getAbsolutePath());
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
     * @return the media
     */
    public Media getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(Media media) {
        this.media = media;
    }

    /**
     * @return the mediaPlayer
     */
    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    /**
     * @param mediaPlayer the mediaPlayer to set
     */
    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    /**
     * @return the mediaView
     */
    public MediaView getMediaView() {
        return mediaView;
    }

    /**
     * @param mediaView the mediaView to set
     */
    public void setMediaView(MediaView mediaView) {
        this.mediaView = mediaView;
    }

    /**
     * @return the primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param primaryStage the primaryStage to set
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * @return the pane
     */
    public Pane getPane() {
        return pane;
    }

    /**
     * @param pane the pane to set
     */
    public void setPane(Pane pane) {
        this.pane = pane;
    }

    /**
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * @param scene the scene to set
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * @return the btnPlayAndPause
     */
    public Button getBtnPlayAndPause() {
        return btnPlayAndPause;
    }

    /**
     * @param btnPlayAndPause the btnPlayAndPause to set
     */
    public void setBtnPlayAndPause(Button btnPlayAndPause) {
        this.btnPlayAndPause = btnPlayAndPause;
    }

}
