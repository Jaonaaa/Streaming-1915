package Were.Event;

import java.awt.event.*;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.event.ActionEvent;
import Were.Infrastructure.LeftSide;
import Were.Infrastructure.RowMedia;
import Were.MultiMedia.Audio;
import Were.MultiMedia.Multimedia;
import Were.MultiMedia.Picture;
import javafx.event.EventHandler;

public class SendRequest implements EventHandler<ActionEvent> {

    ObjectOutputStream dataOut;
    ObjectInputStream dataIn;
    Audio audio = new Audio();
    Picture picture = new Picture();
    RowMedia rowMedia;
    Multimedia multi = new Multimedia();
    Thread threadP = Thread.currentThread();
    LeftSide leftSide;

    public SendRequest(RowMedia row, LeftSide leftSide) {
        this.rowMedia = row;
        this.leftSide = leftSide;
        this.dataOut = row.getLeftSide().getApp().getClient().getDataOut();
        this.dataIn = row.getLeftSide().getApp().getClient().getDataIn();
    }

    @Override
    public void handle(ActionEvent e) {

        if (leftSide.isCanClickButton()) {
            leftSide.setCanClickButton(false);
            if (rowMedia.getContent().contains(".mp3")) {
                System.out.println("mp3");
                forMp3();
            }

            if (rowMedia.getContent().contains(".mp4")) {
                System.out.println("mp4");
                forMp4();
            }

            if (rowMedia.getContent().contains(".jpg")) {
                System.out.println("jpg");
                forPicture();
            }

        }

    }

    public void forMp3() {
        String msg = "audio--" + rowMedia.getContent();
        System.out.println(msg);
        try {
            dataOut.writeObject(msg);
            dataOut.flush();
            System.out.println("READING INT AUDIO ");
            int tailleFile = dataIn.readInt();
            System.out.println("Size of the File :" + tailleFile);

            System.out.println("AUDIOOOO");
            Thread thT = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // audio.getMyFile()
                        multi.copyingSocket(new File("./repository/test.mp3"), tailleFile, dataIn, threadP);
                        leftSide.setCanClickButton(true);
                    } catch (ClassNotFoundException | IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thT.start();
        } catch (Exception e1) {
            System.out.println(e1);
        }

        synchronized (threadP) {
            try {
                threadP.wait();
                System.out.println("Synchronized---MP3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("GO AUdio");
        this.rowMedia.getLeftSide().getApp().getRightSide().getVideoRun().ChangeVideo("mp3");

    }

    public void forMp4() {
        String msg = "video--" + rowMedia.getContent();
        try {
            dataOut.writeObject(msg);
            dataOut.flush();

            System.out.println("READING INT VIDEO");
            int tailleFile = dataIn.readInt();
            System.out.println("Size of the File :" + tailleFile);
            System.out.println("VIDEOOOO");
            // this.video = new Video();
            File file = new File("./repository/test.mp4");
            Thread thT = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        multi.copyingSocket(file, tailleFile, dataIn, threadP);
                        leftSide.setCanClickButton(true);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            });
            thT.start();

        } catch (Exception e1) {
            System.out.println(e1);
        }
        synchronized (threadP) {
            try {
                threadP.wait();
                System.out.println("Synchronized---MP4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("GO video");
        this.rowMedia.getLeftSide().getApp().getRightSide().getVideoRun().ChangeVideo("mp4");
    }

    public void forPicture() {
        String msg = "picture--" + rowMedia.getContent();
        try {
            dataOut.writeObject(msg);
            dataOut.flush();
            System.out.println("READING INT Picture");
            int tailleFile = dataIn.readInt();
            System.out.println("Size of the File :" + tailleFile);
            System.out.println("IMAGEEEE");
            this.picture = new Picture();
            Thread thT = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        multi.copyingSocket(picture.getMyFile(), tailleFile, dataIn, threadP);
                        leftSide.setCanClickButton(true);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            });
            thT.start();
            System.out.println("Picture set ... ");

        } catch (Exception e1) {
            System.out.println(e1);
        }
        synchronized (threadP) {
            try {
                threadP.wait();
                System.out.println("Synchronized---Picture");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("GO image");
        this.rowMedia.getLeftSide().getApp().getRightSide().getVideoRun().ChangeVideo("jpg");
    }

}
