package Were.Runner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.*;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Were.Infrastructure.*;

public class VideoRunner implements Runnable {

    App app;
    RightSide rightSide;
    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    Slider videoSlider;
    Label maxMediaDuration;
    Label currentMediaDuration;
    int status = 0;
    // 1 mp4
    // 2 mp3
    // 3 jpg

    public VideoRunner(RightSide rightSide) {
        this.videoSlider = rightSide.getSliderVideo();
        this.app = rightSide.getApp();
        this.rightSide = rightSide;
        this.media = rightSide.getMedia();
        this.mediaPlayer = rightSide.getMediaPlayer();
        this.mediaView = rightSide.getMediaView();
        this.maxMediaDuration = rightSide.getMaxMediaDuration();
        this.currentMediaDuration = rightSide.getCurrentMediaDuration();
    }

    public VideoRunner(RightSide rightSide, int status) {
        this.videoSlider = rightSide.getSliderVideo();
        this.app = rightSide.getApp();
        this.rightSide = rightSide;
        this.media = rightSide.getMedia();
        this.mediaPlayer = rightSide.getMediaPlayer();
        this.mediaView = rightSide.getMediaView();
        this.status = status;
        this.maxMediaDuration = rightSide.getMaxMediaDuration();
        this.currentMediaDuration = rightSide.getCurrentMediaDuration();
    }

    public void run() {
        System.out.println("READY");
        if (status == 0) {
            mediaPlayer.setAutoPlay(true);
            mediaView = new MediaView(mediaPlayer);
            // mediaView.setFitHeight(media.getHeight() / 2);
            // mediaView.setFitWidth(media.getWidth() / 2);
            mediaView.setFitHeight(500);
            mediaView.setFitWidth(650);
            int durationVideo = (int) media.getDuration().toSeconds();
            System.out.println("Duration media : " + media.getDuration());
            setUpMediaDuration();
            this.videoSlider.setMax(durationVideo);
            setUpVideoPlayer();
            this.videoSlider.setMin(0);
            this.videoSlider.setMinWidth(media.getWidth() / 2);
            this.rightSide.getFuncVideo().setSpacing(10);
            setUpSlider();
            this.rightSide.getFuncVideo().getChildren().addAll(this.rightSide.getBtnPlayAndPause(),
                    this.rightSide.getRestart(), this.currentMediaDuration,
                    this.maxMediaDuration);
            this.rightSide.getFuncVideo().setPadding(new Insets(5, 20, 5, 20));
            this.rightSide.getChildren().addAll(mediaView, this.videoSlider, this.rightSide.getFuncVideo());
        }
        if (status == 1) {
            mediaPlayer.setAutoPlay(true);
            mediaView = new MediaView(mediaPlayer);
            // mediaView.setFitHeight(media.getHeight() / 2);
            // mediaView.setFitWidth(media.getWidth() / 2);
            mediaView.setFitHeight(500);
            mediaView.setFitWidth(650);
            int durationVideo = (int) media.getDuration().toSeconds();
            System.out.println("Duration media : " + media.getDuration());
            setUpMediaDuration();
            this.videoSlider.setMax(durationVideo);
            setUpVideoPlayer();
            this.videoSlider.setMin(0);
            this.videoSlider.setMinWidth(media.getWidth() / 2);
            this.rightSide.getFuncVideo().setSpacing(10);
            setUpSlider();
            this.rightSide.getFuncVideo().getChildren().addAll(this.rightSide.getBtnPlayAndPause(),
                    this.rightSide.getRestart(), this.currentMediaDuration,
                    this.maxMediaDuration);
            this.rightSide.getFuncVideo().setPadding(new Insets(5, 20, 5, 20));
            this.rightSide.getChildren().addAll(mediaView, this.videoSlider, this.rightSide.getFuncVideo());

        }
        if (status == 2) {
            mediaPlayer.setAutoPlay(true);
            Image img = null;
            try {
                img = new Image(new FileInputStream("./Assets/fondMusique.jpg"));
            } catch (FileNotFoundException e) {

                e.printStackTrace();
            }
            this.rightSide.setImagePicture(new ImageView(img));
            this.rightSide.getImagePicture().setFitHeight(420);
            this.rightSide.getImagePicture().setFitWidth(650);

            int durationVideo = (int) media.getDuration().toSeconds();
            System.out.println("Duration media : " + media.getDuration());
            this.videoSlider.setMax(durationVideo);
            setUpVideoPlayer();
            this.videoSlider.setMin(0);
            this.videoSlider.setMinWidth(media.getWidth() / 2);
            this.rightSide.getFuncVideo().setSpacing(10);
            setUpSlider();
            this.rightSide.getFuncVideo().getChildren().addAll(this.rightSide.getBtnPlayAndPause(),
                    this.rightSide.getRestart());
            this.rightSide.getFuncVideo().setPadding(new Insets(5, 20, 5, 20));
            this.rightSide.getChildren().addAll(this.rightSide.getImagePicture(), this.videoSlider,
                    this.rightSide.getFuncVideo());

        }
        if (status == 3) {

        }

    }

    public void ChangeVideo(String extension) {
        mediaPlayer.stop();
        System.out.println("STOPPPP");
        this.rightSide.setGoVideo(false);
        app.setFileToLoad(new File("./repository/test." + extension));
        if (!extension.equals("jpg")) {
            rightSide.setMedia(new Media(app.getFileToLoad().toURI().toString()));
            rightSide.setMediaPlayer(new MediaPlayer(rightSide.getMedia()));
        }

        rightSide.getChildren().remove(this.rightSide.getImagePicture());

        if (extension.equals("mp3")) {
            rightSide.getFuncVideo().getChildren().removeAll(rightSide.getBtnPlayAndPause(), rightSide.getRestart(),
                    rightSide.getCurrentMediaDuration(), rightSide.getMaxMediaDuration());
            rightSide.getChildren().removeAll(mediaView, rightSide.getSliderVideo(), rightSide.getFuncVideo());
            rightSide.setVideoRun(new VideoRunner(rightSide, 2));
        }
        if (extension.equals("mp4")) {
            rightSide.getFuncVideo().getChildren().removeAll(rightSide.getBtnPlayAndPause(), rightSide.getRestart(),
                    rightSide.getCurrentMediaDuration(), rightSide.getMaxMediaDuration());
            rightSide.getChildren().removeAll(mediaView, rightSide.getSliderVideo(), rightSide.getFuncVideo());
            rightSide.setVideoRun(new VideoRunner(rightSide, 1));
        }
        if (extension.equals("jpg")) {
            rightSide.getFuncVideo().getChildren().removeAll(rightSide.getBtnPlayAndPause(), rightSide.getRestart());
            rightSide.getChildren().removeAll(mediaView, rightSide.getSliderVideo(), rightSide.getFuncVideo());
            rightSide.setVideoRun(new VideoRunner(rightSide, 3));
            showImage();
        }
        System.out.println("NOT READY-----------------------------------");

        // while (this.rightSide.isGoVideo() == false) {

        this.rightSide.getMediaPlayer().setOnReady(this.rightSide.getVideoRun());
        // }

        rightSide.setUpBtn();
    }

    public void showImage() {
        Image img = null;
        try {
            img = new Image(new FileInputStream(app.getFileToLoad().getAbsolutePath().toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.rightSide.setImagePicture(new ImageView(img));
        this.rightSide.getImagePicture().setFitHeight(420);
        this.rightSide.getImagePicture().setFitWidth(650);
        this.rightSide.getChildren().addAll(this.rightSide.getImagePicture());
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
                    int currentTime = (int) newValue.toSeconds();
                    currentMediaDuration.setText(tranformTime(currentTime + ""));
                }
            }
        });
    }

    public void setUpMediaDuration() {

        int durationVideo = (int) media.getDuration().toSeconds();
        maxMediaDuration.setText("/  " + tranformTime(durationVideo + ""));
    }

    public String tranformTime(String seconds) {
        int second = Integer.valueOf(seconds);
        int minute = 0;
        int hours = 0;
        if (Integer.valueOf(seconds) >= 60) {
            second = Integer.valueOf(seconds) % 60;
            minute = Integer.valueOf(seconds) / 60;
        }
        if (Integer.valueOf(seconds) >= 3600) {
            hours = Integer.valueOf(seconds) / 3600;
        }
        String time = "";
        if (hours != 0) {
            time += String.format("%02d", hours) + ":";
        }
        // if (minute != 0) {
        time += String.format("%02d", minute) + ":";
        // }
        time += String.format("%02d", second);
        return time;
    }
}
