package Were.Infrastructure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Header extends HBox {

    Button btnCloseStage = new Button("X");

    App app;

    public Header(App app) {
        super();
        this.app = app;
        Image bgImage = null;
        try {
            bgImage = new Image(new FileInputStream("/Users/paul/Desktop/JavaFx/Client/closer.png"));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        btnCloseStage.setPrefSize(30, 30);
        // ImageView imageView = new ImageView(bgImage);
        // imageView.setFitHeight(20);
        // imageView.setFitWidth(30);
        // btnCloseStage.setGraphic(imageView);
        btnCloseStage.getStyleClass().add("closer");
        btnCloseStage.setStyle("-fx-background-color:transparent;-fx-text-fill:white;");
        this.setStyle("-fx-background-color: rgb(20,51,84) ;");
        this.setPrefWidth(app.getMax_width());
        this.setAlignment(Pos.CENTER_RIGHT);
        // btnCloseStage.setPadding(new Insets(10, 10, 10, 10));
        // ;
        this.getChildren().add(btnCloseStage);
        setUpBtn();

    }

    public void setUpBtn() {
        btnCloseStage.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                try {
                    app.getPrimaryStage().close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    /**
     * @return the btnCloseStage
     */
    public Button getBtnCloseStage() {
        return btnCloseStage;
    }

    /**
     * @param btnCloseStage the btnCloseStage to set
     */
    public void setBtnCloseStage(Button btnCloseStage) {
        this.btnCloseStage = btnCloseStage;
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

}
