package Were.Infrastructure;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

import Were.Runner.*;

public class RightSide extends VBox {

    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    Button btnPlayAndPause = new Button("Pause");
    Button restart = new Button("Restart");
    Button changeVideo = new Button("ChangeVideo");
    HBox funcVideo = new HBox();
    Slider sliderVideo = new Slider();
    VideoRunner videoRun;
    App app;

    public RightSide(App app) {
        super();
        this.app = app;
        prepareVideo();

    }

    public void prepareVideo() {
        this.setAlignment(Pos.TOP_CENTER);
        this.media = new Media(app.getFileToLoad().toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
        this.videoRun = new VideoRunner(this);
        this.mediaPlayer.setOnReady(videoRun);
        btnPlayAndPause.setStyle("-fx-font-family:Poppins;");
        restart.setStyle("-fx-font-family:Poppins;");
        setUpBtn();
    }

    public void setUpBtn() {

        // PAUSE AND PLAY VIDEO
        this.btnPlayAndPause.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if (mediaPlayer.statusProperty().getValue().toString().equals("PLAYING")) {
                    mediaPlayer.pause();
                    btnPlayAndPause.setText("Play");
                    ;
                } else {
                    mediaPlayer.play();
                    btnPlayAndPause.setText("Pause");
                }
            }
        });
        // RESTART VIDEO
        this.restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                mediaPlayer.stop();
                mediaPlayer.play();
                btnPlayAndPause.setText("Pause");
            }
        });

    }

    /**
     * @return the videoRun
     */
    public VideoRunner getVideoRun() {
        return videoRun;
    }

    /**
     * @param videoRun the videoRun to set
     */
    public void setVideoRun(VideoRunner videoRun) {
        this.videoRun = videoRun;
    }

    /**
     * @return the media
     */
    public Media getMedia() {
        return media;
    }

    /**
     * @return the changeVideo
     */
    public Button getChangeVideo() {
        return changeVideo;
    }

    /**
     * @param changeVideo the changeVideo to set
     */
    public void setChangeVideo(Button changeVideo) {
        this.changeVideo = changeVideo;
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

    /**
     * @return the restart
     */
    public Button getRestart() {
        return restart;
    }

    /**
     * @param restart the restart to set
     */
    public void setRestart(Button restart) {
        this.restart = restart;
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
     * @return the app
     */
    public App getApp() {
        return app;
    }

    /**
     * @param app the app to set
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * @return the funcVideo
     */
    public HBox getFuncVideo() {
        return funcVideo;
    }

    /**
     * @param funcVideo the funcVideo to set
     */
    public void setFuncVideo(HBox funcVideo) {
        this.funcVideo = funcVideo;
    }

    /**
     * @return the sliderVideo
     */
    public Slider getSliderVideo() {
        return sliderVideo;
    }

    /**
     * @param sliderVideo the sliderVideo to set
     */
    public void setSliderVideo(Slider sliderVideo) {
        this.sliderVideo = sliderVideo;
    }

}
