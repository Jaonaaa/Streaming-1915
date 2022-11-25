package src.runner;

import src.MultiMedia.Video;
import java.io.File;

import src.Infrastructure.Window;

public class VideoLauncher implements Runnable {

    Video video ;
    File mp4 ;
    Window wind ;
    public VideoLauncher(Video video,File mp4,Window window )
    {
        this.video = video;
        this.mp4 = mp4 ;
        this.wind = window;
        this.wind.setVideo(video);

    }
        
    public void run() {
        this.video.start(mp4);
    }
    
}
