package Were.Infrastructure;

import Were.Event.SendRequest;
import javafx.scene.control.Button;

public class RowMedia extends Button {

    String content;
    String title;
    LeftSide leftSide;

    public RowMedia(String text, LeftSide leftSide) {
        this.content = text;
        this.leftSide = leftSide;
        String[] tabWay = text.replace("\\", "#--#").replace("/", "#--#").split("#--#");
        this.setText(tabWay[tabWay.length - 1]);
        this.setOnAction(new SendRequest(this));
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the leftSide
     */
    public LeftSide getLeftSide() {
        return leftSide;
    }

    /**
     * @param leftSide the leftSide to set
     */
    public void setLeftSide(LeftSide leftSide) {
        this.leftSide = leftSide;
    }

}
