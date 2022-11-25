package src.sub;

import java.net.Socket;
import java.util.Vector;

import java.io.*;

import src.Infrastructure.Window;
import src.MultiMedia.*;
import src.runner.VideoLauncher;

public class Client {

    Socket socket;
    String nomClient = "Client";
    Window window;
    Window windowMultimedia ;
    Audio audio = new Audio();
    Video video ;
    ObjectInputStream dataIn ;
    ObjectOutputStream dataOut ;
    public Client() {

    }

    public Client(String nom, Window wind) {
        this.nomClient = nom;
        this.window = wind;
    }

    public void setUpClient(String server, int port) throws IOException, ClassNotFoundException {

        System.out.println("CLIENT --");
        this.socket = new Socket(server, port);
        System.out.println("Connected to the port :" + port);
        this.window.setVisible(false);
        this.window.setConnected(true);
       
        this.dataOut = new ObjectOutputStream(this.getSocket().getOutputStream());
        this.dataIn = new ObjectInputStream(this.getSocket().getInputStream());

        Object resultRest = dataIn.readObject();
        Vector<String> listFileAudio = (Vector<String>) resultRest;

        Object resultRest2 = dataIn.readObject();
        Vector<String> listFileVideo = (Vector<String>) resultRest2;

        Object resultRest3 = dataIn.readObject();
        Vector<String> listFilePicture = (Vector<String>) resultRest3;

        Window windowMulti = new Window(this,listFileAudio,listFileVideo,listFilePicture);
        this.windowMultimedia = windowMulti;
        
        while (true) {
            sendRequest(this.dataOut, this.dataIn);
        }
    }

    public void sendRequest(ObjectOutputStream dataOut, ObjectInputStream dataIn) {
        try {
            Multimedia multi = new Multimedia();
            String msg = "";
            boolean stateOk = false;
            System.out.print(this.getNomClient() + " :");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            msg = br.readLine();
            System.out.println();
            dataOut.writeObject(msg);
            dataOut.flush();
           
            System.out.println("\nResponse : ");

            if (msg.contains("image")) {
                System.out.println("Not done yet ");
            }

            if(stateOk ==false)
            {
                Object resultRest = dataIn.readObject();
                System.out.println(String.valueOf(resultRest));
            }
            
        } catch (

        Exception e) {

            System.out.println(e.getCause().toString());
            System.out.println("Erreur client");
        }
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void setNomClient(String nom) {
        this.nomClient = nom;
    }

    public String getNomClient() {
        return this.nomClient;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Window getWindowMultimedia() {
        return windowMultimedia;
    }

    public void setWindowMultimedia(Window windowMultimedia) {
        this.windowMultimedia = windowMultimedia;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public ObjectInputStream getDataIn() {
        return dataIn;
    }

    public void setDataIn(ObjectInputStream dataIn) {
        this.dataIn = dataIn;
    }

    public ObjectOutputStream getDataOut() {
        return dataOut;
    }

    public void setDataOut(ObjectOutputStream dataOut) {
        this.dataOut = dataOut;
    }

    

}