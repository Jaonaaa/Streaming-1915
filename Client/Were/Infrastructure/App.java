package Were.Infrastructure;

import javafx.application.Application;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.*;

import Were.Connection.ClientConnection;
import Were.MultiMedia.Multimedia;

public class App extends Application {

    Multimedia multi = new Multimedia();
    File fileToLoad = new File("./repository/test.mp3");
    RightSide rightSide;
    LeftSide leftSide;

    Stage primaryStage = new Stage();
    Header header;
    HBox content = new HBox();
    VBox bigBox = new VBox();
    double max_width;
    double max_height;
    Conteneur conteneur;// Scene
    ClientConnection client;

    public void start(Stage primaryStage) throws Exception {

        try {
            this.client = new ClientConnection("localhost", 6666);
        } catch (Exception e) {
            System.out.println(e);
        }

        // this.primaryStage.initStyle(StageStyle.UNDECORATED);
        this.primaryStage.initStyle(StageStyle.TRANSPARENT);
        this.max_height = 600;
        this.max_width = 900;
        this.header = new Header(this);

        rightSide = new RightSide(this);
        leftSide = new LeftSide(this);
        content.getChildren().addAll(leftSide, rightSide);
        bigBox.getChildren().addAll(header, content);
        conteneur = new Conteneur(bigBox, max_width, max_height, this.primaryStage);
        this.primaryStage.setScene(conteneur);

        this.primaryStage.setTitle("Test");
        this.primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @return the fileToLoad
     */
    public File getFileToLoad() {
        return fileToLoad;
    }

    /**
     * @param fileToLoad the fileToLoad to set
     */
    public void setFileToLoad(File fileToLoad) {
        this.fileToLoad = fileToLoad;
    }

    /**
     * @return the rightSide
     */
    public RightSide getRightSide() {
        return rightSide;
    }

    /**
     * @param rightSide the rightSide to set
     */
    public void setRightSide(RightSide rightSide) {
        this.rightSide = rightSide;
    }

    /**
     * @return the header
     */
    public Header getHeader() {
        return header;
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

    /**
     * @return the client
     */
    public ClientConnection getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(ClientConnection client) {
        this.client = client;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(Header header) {
        this.header = header;
    }

    /**
     * @return the max_width
     */
    public double getMax_width() {
        return max_width;
    }

    /**
     * @param max_width the max_width to set
     */
    public void setMax_width(double max_width) {
        this.max_width = max_width;
    }

    /**
     * @return the max_height
     */
    public double getMax_height() {
        return max_height;
    }

    /**
     * @param max_height the max_height to set
     */
    public void setMax_height(double max_height) {
        this.max_height = max_height;
    }

    /**
     * @return the primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param primaryStage the primaryStage to set
     */
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * @return the content
     */
    public HBox getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(HBox content) {
        this.content = content;
    }

    /**
     * @return the bigBox
     */
    public VBox getBigBox() {
        return bigBox;
    }

    /**
     * @param bigBox the bigBox to set
     */
    public void setBigBox(VBox bigBox) {
        this.bigBox = bigBox;
    }

    /**
     * @return the conteneur
     */
    public Conteneur getConteneur() {
        return conteneur;
    }

    /**
     * @param conteneur the conteneur to set
     */
    public void setConteneur(Conteneur conteneur) {
        this.conteneur = conteneur;
    }

    // ----------------------------

}
