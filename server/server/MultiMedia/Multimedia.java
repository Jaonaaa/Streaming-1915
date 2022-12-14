package server.MultiMedia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

public class Multimedia {

    public byte[] getHisByte(File file) throws Exception {
        byte[] bytes = null;
        try {
            Path pa = Paths.get(file.getAbsolutePath());
            bytes = Files.readAllBytes(pa);
            System.out.println(("Bytes of the file : " + bytes.length));
        } catch (Exception e) {
            throw e;
        }
        return bytes;
    }

    public void transfertByte(File file, byte[] bytes, boolean append) throws IOException {
        OutputStream os = null;
        if (append) {
            os = new FileOutputStream(file, true);
        } else {
            os = new FileOutputStream(file);
        }
        os.write(bytes);
        os.close();
    }

    public void copyingSocket(File file, int fullSize, ObjectInputStream dataIn)
            throws ClassNotFoundException, IOException {
        System.out.println("Full size of the file " + fullSize);
        int bytesReceive = 0;
        int tour = 0;
        while (bytesReceive < fullSize) {
            Object obj = dataIn.readObject();
            if (obj instanceof byte[]) {
                byte[] bytes = (byte[]) obj;
                System.out.println("Copying..");
                if (bytesReceive == 0) {
                    transfertByte(file, bytes, false);
                    bytesReceive += bytes.length;
                } else {
                    transfertByte(file, bytes, true);
                    bytesReceive += bytes.length;
                }
                System.out.println("Taille du fichier " + bytesReceive);
            }
            tour++;
        }
        System.out.println("Copying Finish = " + file.getName());
    }

    public void tranferingSocket(File file, ObjectOutputStream dataOut) throws IOException {
        Path path = Paths.get(file.getAbsolutePath());
        System.out.println(path);
        int divider = 10;
        byte[] bytes = Files.readAllBytes(path);
        if (bytes.length > 1000000) {
            divider += bytes.length / 60000;
        }
        System.out.println("The file is divider by " + divider);
        System.out.println("SIZE :" + bytes.length);
        ByteBuffer byteBuff = ByteBuffer.wrap(bytes);
        Vector<byte[]> bytesList = new Vector<byte[]>();
        int totalSend = 0;
        for (int i = 0; i < divider; i++) {
            if (i == divider - 1) {
                int tailleFinaux = bytes.length - totalSend;
                bytesList.add(new byte[tailleFinaux]);
                break;
            } else {
                bytesList.add(new byte[bytes.length / divider]);
            }
            totalSend += bytes.length / divider;
        }
        for (int i = 0; i < bytesList.size(); i++) {
            byteBuff.get(bytesList.get(i), 0, bytesList.get(i).length);
        }
        for (int i = 0; i < bytesList.size(); i++) {
            System.out.println("Sending " + i);
            dataOut.writeObject(bytesList.get(i));
        }
        System.out.println("File sended ");
    }

    public File[] getFileList(String repositoryPath) {
        File file = new File(repositoryPath);
        return file.listFiles();
    }

    public Vector<String> getListMedia(String repositoryPath, String extension) {
        Vector<String> listFiles = new Vector<String>();
        File[] files = getFileList(repositoryPath);
        for (int i = 0; i < files.length; i++) {
            if (!files[i].getAbsolutePath().contains(extension)) {
                continue;
            }
            listFiles.add(files[i].getAbsolutePath());
        }
        return listFiles;
    }
}
