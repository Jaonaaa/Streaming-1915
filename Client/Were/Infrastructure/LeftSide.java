package Were.Infrastructure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Vector;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class LeftSide extends VBox {

    App app;
    Label title = new Label("Media");
    Vector<Button> buttons = new Vector<Button>();
    ScrollPane scrollPane;
    VBox mediaScroll = new VBox();
    boolean canClickButton = true;

    public LeftSide(App app) {
        super();
        this.app = app;
        this.setPrefWidth(250);
        this.setPrefHeight(app.getMax_height() - 30);

        this.getChildren().add(title);
        setUpTitle();
        this.setStyle("-fx-background-radius:0px 0px 9px 0px !important;");
        this.mediaScroll.setStyle("-fx-background-radius:0px 0px 9px 0px !important;");
        setUpButtons();
        this.setAlignment(Pos.TOP_CENTER);
        this.mediaScroll.setMaxWidth(250);
        scrollPane = new ScrollPane();
        scrollPane.setContent(this.mediaScroll);
        scrollPane.setPrefHeight(app.getMax_height() - 30);
        scrollPane.setPrefWidth(300);

        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.scrollPane
                .setStyle("-fx-background-radius: 20px !important;");
        this.getChildren().add(scrollPane);
    }

    public void setUpTitle() {
        title.setStyle(
                "-fx-font-size:24px;-fx-font-family:Poppins;-fx-background-color: rgb(20,51,84);-fx-text-fill:white;");
        title.setPrefHeight(65);
        title.setPrefWidth(250);
        title.setMinHeight(65);
        title.setAlignment(Pos.CENTER);
    }

    public void setUpButtons() {
        Vector<String> listMedia = this.app.getClient().getAllMediaList();
        for (int i = 0; i < listMedia.size(); i++) {
            Image bgImage = null;
            try {
                if (listMedia.get(i).contains(".mp3")) {
                    bgImage = new Image(new FileInputStream("./Assets/musique.png"));
                } else if (listMedia.get(i).contains(".mp4")) {
                    bgImage = new Image(new FileInputStream("./Assets/video.png"));
                } else if (listMedia.get(i).contains(".jpg") || listMedia.get(i).contains(".png")) {
                    bgImage = new Image(new FileInputStream("./Assets/paysage.jpg"));

                }

            } catch (FileNotFoundException e) {
                System.out.println(e);
            }

            ImageView imageView = new ImageView(bgImage);
            imageView.setFitHeight(35);
            imageView.setFitWidth(30);

            RowMedia btn = new RowMedia(listMedia.get(i), this);
            btn.setContentDisplay(ContentDisplay.LEFT);
            btn.setPrefWidth(240);
            btn.setMinHeight(50);
            btn.setBackground(null);
            btn.setGraphic(imageView);
            btn.getStyleClass().add("btnMusic");
            buttons.add(btn);
        }
        // /this.mediaScroll.setPrefWidth(300);
        for (int i = 0; i < buttons.size(); i++) {
            this.mediaScroll.getChildren().add(buttons.get(i));
        }
    }

    /**
     * @return the app
     */
    public App getApp() {
        return app;
    }

    /**
     * @return the buttons
     */
    public Vector<Button> getButtons() {
        return buttons;
    }

    /**
     * @param buttons the buttons to set
     */
    public void setButtons(Vector<Button> buttons) {
        this.buttons = buttons;
    }

    /**
     * @return the scrollPane
     */
    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * @param scrollPane the scrollPane to set
     */
    public void setScrollPane(ScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * @return the mediaScroll
     */
    public VBox getMediaScroll() {
        return mediaScroll;
    }

    /**
     * @param mediaScroll the mediaScroll to set
     */
    public void setMediaScroll(VBox mediaScroll) {
        this.mediaScroll = mediaScroll;
    }

    /**
     * @return the canClickButton
     */
    public boolean isCanClickButton() {
        return canClickButton;
    }

    /**
     * @param canClickButton the canClickButton to set
     */
    public void setCanClickButton(boolean canClickButton) {
        this.canClickButton = canClickButton;
    }

    /**
     * @param app the app to set
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * @return the title
     */
    public Label getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(Label title) {
        this.title = title;
    }

}
