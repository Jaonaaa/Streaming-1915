
package Were.Infrastructure;

import javafx.event.EventHandler;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Conteneur extends Scene {

    double offsetX = 0;
    double offsetY = 0;
    Color bgColor = Color.rgb(35, 108, 122, 1);

    public Conteneur(Parent arg0, double width, double height, Stage stage) {
        super(arg0, width, height, Color.TRANSPARENT);
        arg0.setStyle("-fx-background-radius:9px !important; -fx-padding :0 0 0 0;");
        // Rectangle rect = new Rectangle(stage.getMaxWidth(), stage.getMaxHeight());
        // arg0.setClip(rect);
        this.getStylesheets().add("app.css");
        this.setFill(Color.TRANSPARENT);
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                offsetX = event.getSceneX();
                offsetY = event.getScreenY();
            }
        });
        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - offsetX);
                stage.setY(event.getScreenY() - offsetY);
            }
        });

    }

}
