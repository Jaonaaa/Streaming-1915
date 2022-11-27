package Were.Runner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableNumberValue;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Slider;
import javafx.scene.media.*;
import javafx.util.Duration;

import java.io.File;

import Were.Infrastructure.*;

public class VideoRunner implements Runnable {

    App app;
    RightSide rightSide;
    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    Slider videoSlider;

    public VideoRunner(RightSide rightSide) {
        this.videoSlider = rightSide.getSliderVideo();
        this.app = rightSide.getApp();
        this.rightSide = rightSide;
        this.media = rightSide.getMedia();
        this.mediaPlayer = rightSide.getMediaPlayer();
        this.mediaView = rightSide.getMediaView();
    }

    public void run() {

        mediaPlayer.setAutoPlay(true);
        mediaView = new MediaView(mediaPlayer);
        mediaView.setFitHeight(media.getHeight() / 2);
        mediaView.setFitWidth(media.getWidth() / 2);

        int durationVideo = (int) media.getDuration().toSeconds();
        System.out.println("Duration media : " + media.getDuration());
        this.videoSlider.setMax(durationVideo);
        setUpVideoPlayer();
        this.videoSlider.setMin(0);
        this.videoSlider.setMinWidth(media.getWidth() / 2);
        this.rightSide.getFuncVideo().setSpacing(10);
        setUpSlider();

        this.rightSide.getFuncVideo().getChildren().addAll(this.rightSide.getBtnPlayAndPause(),
                this.rightSide.getRestart(), this.rightSide.getChangeVideo());
        this.rightSide.getFuncVideo().setPadding(new Insets(5, 20, 5, 20));
        this.rightSide.getChildren().addAll(mediaView, this.videoSlider, this.rightSide.getFuncVideo());
        setUpVideoChanger();

    }

    public void setUpVideoChanger() {
        // CHANGE VIDEO
        this.rightSide.getChangeVideo().setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                mediaPlayer.stop();
                System.out.println("STOPPPP");
                app.setFileToLoad(new File("./repository/test.mp4"));
                rightSide.setMedia(new Media(app.getFileToLoad().toURI().toString()));
                rightSide.setMediaPlayer(new MediaPlayer(rightSide.getMedia()));
                rightSide.getFuncVideo().getChildren().removeAll(rightSide.getBtnPlayAndPause(), rightSide.getRestart(),
                        rightSide.getChangeVideo());
                rightSide.getChildren().removeAll(mediaView, rightSide.getSliderVideo(), rightSide.getFuncVideo());
                rightSide.setVideoRun(new VideoRunner(rightSide));
                rightSide.getMediaPlayer().setOnReady(rightSide.getVideoRun());
                rightSide.setUpBtn();
            }
        });
    }

    public void ChangeVideo(String extension) {
        mediaPlayer.stop();
        System.out.println("STOPPPP");
        app.setFileToLoad(new File("./repository/test." + extension));
        rightSide.setMedia(new Media(app.getFileToLoad().toURI().toString()));
        rightSide.setMediaPlayer(new MediaPlayer(rightSide.getMedia()));
        rightSide.getFuncVideo().getChildren().removeAll(rightSide.getBtnPlayAndPause(), rightSide.getRestart(),
                rightSide.getChangeVideo());
        rightSide.getChildren().removeAll(mediaView, rightSide.getSliderVideo(), rightSide.getFuncVideo());
        rightSide.setVideoRun(new VideoRunner(rightSide));
        rightSide.getMediaPlayer().setOnReady(rightSide.getVideoRun());
        rightSide.setUpBtn();
    }

    public void setUpSlider() {
        // le bouton iny ny hahietsika , tsindrina de avototra de miova
        this.videoSlider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean wasChanging, Boolean isChanging) {
                if (!isChanging) {
                    mediaPlayer.seek(Duration.seconds(videoSlider.getValue()));
                }
            }
        });
        // le bouton ahietsika mintsy ty
        this.videoSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
                double currentTime = mediaPlayer.getCurrentTime().toSeconds();
                /*
                 * System.out.println("Duration max" + media.getDuration().toSeconds());
                 * System.out.println("curent Time :" + currentTime);
                 * System.out.println("New Value :" + newValue.doubleValue());
                 */
                if (Math.abs(currentTime - newValue.doubleValue()) > 0.5) {
                    mediaPlayer.seek(Duration.seconds(newValue.doubleValue()));
                }
            }
        });

    }

    public void setUpVideoPlayer() {
        this.mediaPlayer.totalDurationProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> arg0, Duration oldDuration, Duration newDuration) {
                videoSlider.setMax(newDuration.toSeconds());
            }
        });

        this.mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> arg0, Duration oldValue, Duration newValue) {
                if (!videoSlider.isValueChanging()) {
                    videoSlider.setValue(newValue.toSeconds());
                }
            }
        });
    }
}
