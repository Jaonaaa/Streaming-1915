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

    public LeftSide(App app) {
        super();
        this.app = app;
        this.setPrefWidth(300);
        this.setPrefHeight(app.getMax_height() - 30);

        this.getChildren().add(title);
        setUpTitle();
        setUpButtons();
        this.setAlignment(Pos.TOP_CENTER);

        scrollPane = new ScrollPane();
        scrollPane.setContent(this.mediaScroll);
        scrollPane.setPrefHeight(app.getMax_height() - 30);
        scrollPane.setPrefWidth(300);

        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.getChildren().add(scrollPane);
    }

    public void setUpTitle() {
        title.setStyle(
                "-fx-font-size:24px;-fx-font-family:Poppins;-fx-background-color:rgba(3,67,135,1);-fx-text-fill:white;");
        title.setPrefHeight(65);
        title.setPrefWidth(300);
        title.setMinHeight(65);
        title.setAlignment(Pos.CENTER);
    }

    public void setUpButtons() {
        Vector<String> listMedia = this.app.getClient().getAllMediaList();
        for (int i = 0; i < listMedia.size(); i++) {
            Image bgImage = null;
            try {
                bgImage = new Image(new FileInputStream("/Users/paul/Desktop/JavaFx/Client/closer.png"));
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }

            ImageView imageView = new ImageView(bgImage);
            imageView.setFitHeight(20);
            imageView.setFitWidth(30);

            RowMedia btn = new RowMedia(listMedia.get(i), this);
            btn.setContentDisplay(ContentDisplay.LEFT);
            btn.setPrefWidth(250);
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
