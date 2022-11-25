package src.Infrastructure;

import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.*;
import src.Listener.WindowListen;
import src.MultiMedia.Audio;
import src.MultiMedia.Video;
import src.runner.Connection;
import src.sub.Client;

public class Window extends JFrame {

    Client client;
    Input textFieldIp;
    Input textFieldPort;
    Input clientName;
    JLabel title;
    Bouton connectBtn;
    Boolean connected = false;
    Video video ;

    public Window() {
        super("Connection...");
        this.setSize(600, 430);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.textFieldIp = new Input(50, 70, this, "Ip address :");
        textFieldIp.getTextField().setText("localhost");
        this.textFieldPort = new Input(50, 130, this, "Port :");
        textFieldPort.getTextField().setText("6666");
        this.title = new JLabel("You want to connect to which server ?");
        this.title.setBounds(this.getWidth() / 3, 10, 300, 60);
        this.clientName = new Input(50, 190, this, "Your name :");
        this.clientName.getTextField().setText("Peter");
        this.connectBtn = new Bouton((this.getWidth() / 2) - 50, 260, this, "Valider");
        this.connectBtn.addActionListener(new WindowListen(this, this.connectBtn));
        this.add(this.title);
        this.add(textFieldIp);
        this.add(textFieldPort);
        this.add(clientName);
        this.add(connectBtn);
        this.setVisible(true);
    }

    public Boolean setUpConnection(String nom, String ipAddress, int port)
            throws ClassNotFoundException, IOException, InterruptedException {
        Thread th = new Thread(new Connection(this, nom, ipAddress, port));
        th.start();
        return connected;
    }

    public Window(Client client,Vector<String> filesPath,Vector<String> videosPath ,Vector<String> picturesPath) {
        super("Hirako");
        this.client = client;
        this.setSize(1000, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel panneauMusic = new JPanel();
        JPanel panneauVideo = new JPanel();
        JPanel panneauPicture = new JPanel();
        JLabel titleMusic = new JLabel("Music");
        JLabel titleVideo = new JLabel("Video");
        JLabel titlePicture = new JLabel("Picture");
        //------------------
        titleMusic.setFont(new Font("TimesRoman",Font.ITALIC, 30));
        titleMusic.setBounds(130, 10, 200, 50);
        panneauMusic.add(titleMusic);
        //-----------------------
        titleVideo.setFont(new Font("TimesRoman",Font.ITALIC, 30));
        titleVideo.setBounds(130, 10, 200, 50);
        panneauVideo.add(titleVideo);
        //----------------------
        titlePicture.setFont(new Font("TimesRoman",Font.ITALIC, 30));
        titlePicture.setBounds(130, 10, 200, 50);
        panneauPicture.add(titlePicture);
        //----------------------
        panneauMusic.setLayout(null);
        panneauMusic.setBounds(100, 10, 300, 450);
        //----------------------------
        panneauVideo.setLayout(null);
        panneauVideo.setBounds(100, 10, 300, 450);
        //------------------------
        panneauPicture.setLayout(null);
        panneauPicture.setBounds(100, 10, 300, 450);
        //------------------------

        setMulti(panneauMusic, filesPath);
        setMulti(panneauVideo, videosPath);
        setMulti(panneauPicture, picturesPath);

        JScrollPane jsPanneMusic = new JScrollPane(panneauMusic);
        jsPanneMusic.setBounds(0, 0, 330, this.getHeight());
        jsPanneMusic.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JScrollPane jsPanneVideo = new JScrollPane(panneauVideo);
        jsPanneVideo.setBounds(340, 0, 330, this.getHeight());
        jsPanneVideo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JScrollPane jsPannePicture = new JScrollPane(panneauPicture);
        jsPannePicture.setBounds(650, 0, 330, this.getHeight());
        jsPannePicture.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(jsPanneMusic);
        this.add(jsPanneVideo);
        this.add(jsPannePicture);
        this.setVisible(true);
    }

    public void setMulti(JPanel pane,Vector<String> list)
    {
        int yPlace =70 ;
        for(int i=0;i<list.size();i++)
        {
            RowMusic row = new RowMusic(0, yPlace, pane, list.get(i),this);
            pane.add(row);
            yPlace+=53;
        }
    }
    
    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the textFieldIp
     */
    public Input getTextFieldIp() {
        return textFieldIp;
    }

    /**
     * @param textFieldIp the textFieldIp to set
     */
    public void setTextFieldIp(Input textFieldIp) {
        this.textFieldIp = textFieldIp;
    }

    /**
     * @return the textFieldPort
     */
    public Input getTextFieldPort() {
        return textFieldPort;
    }

    /**
     * @return the connectBtn
     */
    public Bouton getConnectBtn() {
        return connectBtn;
    }

    /**
     * @param connectBtn the connectBtn to set
     */
    public void setConnectBtn(Bouton connectBtn) {
        this.connectBtn = connectBtn;
    }

    /**
     * @param textFieldPort the textFieldPort to set
     */
    public void setTextFieldPort(Input textFieldPort) {
        this.textFieldPort = textFieldPort;
    }

    /**
     * @return the title
     */
    public JLabel getTitlee() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(JLabel title) {
        this.title = title;
    }

    /**
     * @return the clientName
     */
    public Input getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(Input clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the connected
     */
    public Boolean getConnected() {
        return connected;
    }

    /**
     * @param connected the connected to set
     */
    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
    

}
