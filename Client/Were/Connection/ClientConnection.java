package Were.Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

public class ClientConnection {

    Socket socket;
    ObjectInputStream dataIn;
    ObjectOutputStream dataOut;
    Vector<String> listFileAudio;
    Vector<String> listFileVideo;
    Vector<String> listFilePicture;
    Vector<String> allMediaList = new Vector<String>();

    public ClientConnection(String ip, int port) throws Exception {
        setUpSocket(ip, port);
    }

    public void setUpSocket(String ip, int port) throws UnknownHostException, IOException, ClassNotFoundException {
        this.socket = new Socket(ip, port);
        this.dataOut = new ObjectOutputStream(this.getSocket().getOutputStream());
        this.dataIn = new ObjectInputStream(this.getSocket().getInputStream());

        Object resultRest1 = dataIn.readObject();
        this.listFileAudio = (Vector<String>) resultRest1;

        Object resultRest2 = dataIn.readObject();
        this.listFileVideo = (Vector<String>) resultRest2;

        Object resultRest3 = dataIn.readObject();
        this.listFilePicture = (Vector<String>) resultRest3;
        setUpAllMedia();
    }

    public void setUpAllMedia() {
        for (int i = 0; i < this.listFileAudio.size(); i++) {
            this.allMediaList.add(listFileAudio.get(i));
        }
        for (int i = 0; i < this.listFilePicture.size(); i++) {
            this.allMediaList.add(listFilePicture.get(i));
        }
        for (int i = 0; i < this.listFileVideo.size(); i++) {
            this.allMediaList.add(listFileVideo.get(i));
        }
    }

    /**
     * @return the socket
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * @return the dataIn
     */
    public ObjectInputStream getDataIn() {
        return dataIn;
    }

    /**
     * @param dataIn the dataIn to set
     */
    public void setDataIn(ObjectInputStream dataIn) {
        this.dataIn = dataIn;
    }

    /**
     * @return the dataOut
     */
    public ObjectOutputStream getDataOut() {
        return dataOut;
    }

    /**
     * @param dataOut the dataOut to set
     */
    public void setDataOut(ObjectOutputStream dataOut) {
        this.dataOut = dataOut;
    }

    /**
     * @return the listFileAudio
     */
    public Vector<String> getListFileAudio() {
        return listFileAudio;
    }

    /**
     * @param listFileAudio the listFileAudio to set
     */
    public void setListFileAudio(Vector<String> listFileAudio) {
        this.listFileAudio = listFileAudio;
    }

    /**
     * @return the listFileVideo
     */
    public Vector<String> getListFileVideo() {
        return listFileVideo;
    }

    /**
     * @param listFileVideo the listFileVideo to set
     */
    public void setListFileVideo(Vector<String> listFileVideo) {
        this.listFileVideo = listFileVideo;
    }

    /**
     * @return the listFilePicture
     */
    public Vector<String> getListFilePicture() {
        return listFilePicture;
    }

    /**
     * @param listFilePicture the listFilePicture to set
     */
    public void setListFilePicture(Vector<String> listFilePicture) {
        this.listFilePicture = listFilePicture;
    }

    /**
     * @return the allMediaList
     */
    public Vector<String> getAllMediaList() {
        return allMediaList;
    }

    /**
     * @param allMediaList the allMediaList to set
     */
    public void setAllMediaList(Vector<String> allMediaList) {
        this.allMediaList = allMediaList;
    }

}
