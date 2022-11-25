package src.runner;

import java.io.File;

import javax.swing.plaf.synth.SynthStyle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.WindowEvent;
import src.MultiMedia.Video;

public class VideoRunner implements Runnable {

    Video video;

    public VideoRunner(Video video) {
        this.video = video;
    }

    @Override
    public void run() {
        // Instantiating MediaView class
        video.setMediaView(new MediaView(video.getMediaPlayer()));
        // by setting this property to true, the Video will be played
        video.getMediaPlayer().setAutoPlay(true);
        video.setPane(new Pane());
        // MotionBlur motion = new MotionBlur();
        // root.setEffect(motion);
        // root.setTranslateX(100);
        video.setBtnPlayAndPause(new Button("Status"));
        video.getBtnPlayAndPause().setPrefSize(80, 50);
        video.getBtnPlayAndPause().setLayoutX(20);
        Pane paneButtons = new Pane();
        paneButtons.setPadding(new Insets(100));
        paneButtons.setLayoutY(video.getMedia().getHeight()-200);
        paneButtons.getChildren().addAll(video.getBtnPlayAndPause());
        video.getPane().getChildren().addAll(paneButtons, video.getMediaView());

       // video.setScene(new Scene(video.getPane(), video.getMedia().getWidth(), video.getMedia().getHeight() + 200));
       video.getMediaView().setFitWidth(700);
       video.getMediaView().setFitHeight(700);
       video.setScene(new Scene(video.getPane(),700, 700));
        // change
        //video.setScene(new Scene(video.getPane(), video.getMedia().getWidth(), video.getMedia().getHeight() + 800));
        //
        video.getPrimaryStage().setScene(video.getScene());
        video.getPrimaryStage().setTitle(video.getMyFile().getName());
        video.getPrimaryStage().show();

        video.getPrimaryStage().widthProperty().addListener((obs, oldVal, newVal) -> {
            double newWidth = Double.valueOf(String.valueOf(newVal));
            video.getMediaView().setFitWidth(newWidth);
            video.getPrimaryStage()
                    .setHeight(video.RDT(video.getMedia().getWidth(),
                            video.getMedia().getHeight(), newWidth));
        });
        video.getPrimaryStage().heightProperty().addListener((obs, oldVal, newVal) -> {
            double newHeigth = Double.valueOf(String.valueOf(newVal));
            video.getMediaView().setFitHeight(newHeigth);

        });

        video.getPrimaryStage().setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent arg0) {
                try {
                    video.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        handleBtn(video);

    }

    public void handleBtn(Video video) {
        video.getBtnPlayAndPause().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if (video.getMediaPlayer().statusProperty().getValue().name().toString().equals("PLAYING")) {
                    video.getMediaPlayer().pause();
                } else {
                    video.getMediaPlayer().play();
                }
                

                File file = new File("C:/Users/ITU/Desktop/Naina/StreamingApp 2/./repository/tomcat.mp4");
                Media media = new Media(file.toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setOnReady(
                new Runnable() {
                    @Override
                    public void run() {
                        MediaView mediaView = new MediaView(mediaPlayer);
                        Pane pane = new Pane();
                        pane.getChildren().addAll(mediaView);
                        Scene scene = new Scene(pane,700,700);
                        video.getPrimaryStage().setScene(scene);
                    }
                }
                );
                
                

            }
        });
    }

}
