package src.MultiMedia;

import java.io.File;

public class Picture extends Multimedia{
    
    File myFile = new File("./repository/test.jpg");

    public Picture()
    {
        
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    
}
