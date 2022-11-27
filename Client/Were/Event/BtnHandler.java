package Were.Event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.FileChooser;

import java.io.File;

import Were.Infrastructure.*;

public class BtnHandler implements EventHandler<ActionEvent> {

    App app;

    public BtnHandler(App app) {
        this.app = app;
    }

    public void handle(ActionEvent arg0) {
        FileChooser fileChoser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Mp4 only ", "*.mp4");
        fileChoser.getExtensionFilters().add(filter);
        File f = fileChoser.showOpenDialog(null);
        this.app.setFileToLoad(f);

    }

}
