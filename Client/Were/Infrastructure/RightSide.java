package Were.Infrastructure;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.FileInputStream;
import Were.Runner.*;

public class RightSide extends VBox {

    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    Button btnPlayAndPause = new Button();
    Button restart = new Button("Restart");
    Label maxMediaDuration = new Label("/  00:00");
    Label currentMediaDuration = new Label("00:00");
    HBox funcVideo = new HBox();
    Slider sliderVideo = new Slider();
    VideoRunner videoRun;
    ImageView imageViewPause;
    ImageView imageViewPlay;
    ImageView imagePicture;
    App app;
    boolean goVideo = false;

    public RightSide(App app) throws Exception {
        super();
        this.imageViewPause = new ImageView(new Image(new FileInputStream("./Assets/pause.jpg")));
        this.imageViewPlay = new ImageView(new Image(new FileInputStream("./Assets/play.png")));
        this.imageViewPause.setFitHeight(30);
        this.imageViewPause.setFitWidth(30);
        this.imageViewPlay.setFitHeight(30);
        this.imageViewPlay.setFitWidth(30);
        this.app = app;
        this.maxMediaDuration.setPrefSize(60, 40);

        this.currentMediaDuration.setPrefSize(60, 40);
        this.currentMediaDuration.setAlignment(Pos.CENTER_RIGHT);
        this.maxMediaDuration.setAlignment(Pos.CENTER_LEFT);
        this.setStyle("-fx-background-color:white;");
        prepareVideo();
    }

    public void prepareVideo() {
        this.setAlignment(Pos.TOP_CENTER);
        this.media = new Media(app.getFileToLoad().toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
        this.videoRun = new VideoRunner(this);
        // this.mediaPlayer.setOnReady(videoRun);
        btnPlayAndPause.setStyle("-fx-font-family:Poppins;");
        restart.setStyle("-fx-font-family:Poppins;");
        setUpBtn();
    }

    public void setUpBtn() {

        // PAUSE AND PLAY VIDEO
        this.btnPlayAndPause.setGraphic(this.imageViewPause);
        this.btnPlayAndPause.setContentDisplay(ContentDisplay.CENTER);
        this.restart.setPrefHeight(40);
        this.btnPlayAndPause.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if (mediaPlayer.statusProperty().getValue().toString().equals("PLAYING")) {
                    mediaPlayer.pause();
                    btnPlayAndPause.setGraphic(imageViewPlay);
                    ;
                } else {
                    mediaPlayer.play();
                    btnPlayAndPause.setGraphic(imageViewPause);
                }
            }
        });
        // RESTART VIDEO
        this.restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                mediaPlayer.stop();
                mediaPlayer.play();
                btnPlayAndPause.setGraphic(imageViewPause);
                ;
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
     * @return the maxMediaDuration
     */
    public Label getMaxMediaDuration() {
        return maxMediaDuration;
    }

    /**
     * @param maxMediaDuration the maxMediaDuration to set
     */
    public void setMaxMediaDuration(Label maxMediaDuration) {
        this.maxMediaDuration = maxMediaDuration;
    }

    /**
     * @return the currentMediaDuration
     */
    public Label getCurrentMediaDuration() {
        return currentMediaDuration;
    }

    /**
     * @param currentMediaDuration the currentMediaDuration to set
     */
    public void setCurrentMediaDuration(Label currentMediaDuration) {
        this.currentMediaDuration = currentMediaDuration;
    }

    /**
     * @return the goVideo
     */
    public boolean isGoVideo() {
        return goVideo;
    }

    /**
     * @param goVideo the goVideo to set
     */
    public void setGoVideo(boolean goVideo) {
        this.goVideo = goVideo;
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
     * @return the imageViewPause
     */
    public ImageView getImageViewPause() {
        return imageViewPause;
    }

    /**
     * @param imageViewPause the imageViewPause to set
     */
    public void setImageViewPause(ImageView imageViewPause) {
        this.imageViewPause = imageViewPause;
    }

    /**
     * @return the imageViewPlay
     */
    public ImageView getImageViewPlay() {
        return imageViewPlay;
    }

    /**
     * @param imageViewPlay the imageViewPlay to set
     */
    public void setImageViewPlay(ImageView imageViewPlay) {
        this.imageViewPlay = imageViewPlay;
    }

    /**
     * @return the imagePicture
     */
    public ImageView getImagePicture() {
        return imagePicture;
    }

    /**
     * @param imagePicture the imagePicture to set
     */
    public void setImagePicture(ImageView imagePicture) {
        this.imagePicture = imagePicture;
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
