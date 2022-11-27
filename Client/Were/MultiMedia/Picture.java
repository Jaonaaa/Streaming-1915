package Were.MultiMedia;

import java.io.File;

public class Picture extends Multimedia {

    File myFile = new File("./repository/test.jpg");

    public Picture() {
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

}
