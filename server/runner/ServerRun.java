package server.runner;

import java.io.*;
import java.net.Socket;
import java.util.Vector;

import server.MultiMedia.*;

public class ServerRun implements Runnable {

    Socket socket;

    public ServerRun(Socket socket) throws IOException {
        this.socket = socket;
    }

    public void run() {
        try {
            System.out.println(socket);
            serverTreatement(this.socket);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void serverTreatement(Socket socket) throws IOException {
        ObjectInputStream dataIn = new ObjectInputStream(socket.getInputStream());
        System.out.println("Client connected ");
        ObjectOutputStream dataOut = new ObjectOutputStream(socket.getOutputStream());
        Multimedia multi = new Multimedia();

        Vector<String> listMediaAudio = multi.getListMedia("./repository/", ".mp3");
        dataOut.writeObject(listMediaAudio);

        Vector<String> listMediaVideo = multi.getListMedia("./repository/", ".mp4");
        dataOut.writeObject(listMediaVideo);

        Vector<String> listMediaPicture = multi.getListMedia("./repository/", ".jpg");
        dataOut.writeObject(listMediaPicture);
        String msg = "";

        while (true) {
            try {
                System.out.println("Reading msg");
                msg = (String) dataIn.readObject();
                boolean stateOk = false;
                if (msg.equals("reco")) {
                    break;
                }
                System.out.println("\nClient : " + msg);
                System.out.print("Server sending");

                if (msg.contains("audio--")) {
                    System.out.println("  AUDIIIO");
                    msg = msg.replace("audio--", "");
                    stateOk = true;
                    byte[] bytes = multi.getHisByte(new File(msg));
                    dataOut.writeInt(bytes.length);
                    System.out.println("Size of the bytes send " + bytes.length);
                    System.out.println();
                    dataOut.writeObject(bytes);
                }

                if (msg.contains("video--")) {

                    msg = msg.replace("video--", "");
                    System.out.println(" VIDEOOOO");
                    stateOk = true;

                    // mandefa taille ftnsy ty
                    System.out.println(msg);
                    byte[] bytes = multi.getHisByte(new File(msg));
                    dataOut.writeInt(bytes.length);
                    // mandefa anleh byte an video amzay ty
                    multi.tranferingSocket(new File(msg), dataOut);
                }

                if (msg.contains("picture--")) {

                    msg = msg.replace("picture--", "");
                    System.out.println(" IMAGEEE");
                    stateOk = true;
                    // mandefa taille ftnsy ty
                    byte[] bytes = multi.getHisByte(new File(msg));
                    dataOut.writeInt(bytes.length);
                    // mandefa anleh byte
                    multi.tranferingSocket(new File(msg), dataOut);
                }

                if (stateOk == false) {
                    dataOut.writeObject("Veuillez choisir entre : audio - video - image ");
                }
                dataOut.flush();

            } catch (Exception e) {
                System.out.println(e);
                break;
            }
        }
        socket.close();
    }

}