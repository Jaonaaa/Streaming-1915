package src.Listener;

import java.awt.event.*;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.ObjectInputStream;


import src.Infrastructure.RowMusic;
import src.Infrastructure.Window;
import src.MultiMedia.Audio;
import src.MultiMedia.Multimedia;
import src.MultiMedia.Picture;
import src.MultiMedia.Video;
import src.runner.AudioRunner;
import src.runner.VideoLauncher;

public class ButtonMusicListener implements ActionListener {

    RowMusic rowMusic;
    ObjectOutputStream dataOut ;
    ObjectInputStream dataIn ;
    Audio audio ;
    Video video ;
    Picture picture;
    Window wind ;
    public ButtonMusicListener(RowMusic row)
    {
        this.rowMusic = row ;
        this.dataOut  = row.getWind().getClient().getDataOut();
        this.dataIn  = row.getWind().getClient().getDataIn();
        this.audio = row.getWind().getClient().getAudio();
        this.wind = row.getWind();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Multimedia multi = new Multimedia();
        if(rowMusic.getContent().contains(".mp3"))
        {
            String msg = "audio--"+rowMusic.getContent();
            System.out.println(msg);
        try {
                this.audio.getMyAudio().close();
                dataOut.writeObject(msg);
                dataOut.flush();
                
                System.out.println("READING INT AUDIO "+dataIn.available());
                int tailleFile = dataIn.readInt();
                System.out.println("Size of the File :" + tailleFile);
           
                System.out.println("AUDIOOOO");
                multi.copyingSocket(this.audio.getMyFile(), tailleFile, dataIn);
                Thread th = new Thread(new AudioRunner(rowMusic.getLabel().getText(),this.audio));
                th.start();
                System.out.println("Audio stopped"); 


            }catch (Exception e1) {
                System.out.println(e1);
            }
        }

        if(rowMusic.getContent().contains(".mp4"))
        {
            String msg = "video--"+rowMusic.getContent();
            try {
                dataOut.writeObject(msg);
                dataOut.flush();

                System.out.println("READING INT VIDEO");
                int tailleFile = dataIn.readInt();
                System.out.println("Size of the File :" + tailleFile);
                System.out.println("VIDEOOOO");
                this.video = new Video();
                File file = new File("./repository/test.mp4");
                multi.copyingSocket(file, tailleFile, dataIn);
                System.out.println("Video starting ... ");
                if(this.wind.getVideo()==null)
                {
                    Thread th = new Thread(new VideoLauncher(this.video,file,this.wind));
                    th.start();
                }
                else
                {
                    System.out.println("\n\n"+this.wind.getVideo().getPrimaryStage());
                }
                System.out.println("Video started");
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }



        if(rowMusic.getContent().contains(".jpg"))
        {
            String msg = "picture--"+rowMusic.getContent();
            try {
                dataOut.writeObject(msg);
                dataOut.flush();

                System.out.println("READING INT Picture");
                int tailleFile = dataIn.readInt();
                System.out.println("Size of the File :" + tailleFile);
                System.out.println("VIDEOOOO");
                this.picture = new Picture();
                multi.copyingSocket(this.picture.getMyFile(), tailleFile, dataIn);
                System.out.println("Picture set ... ");
                
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }
    }
    
    public void canPlayAnotherSong()
    {

    }
}
