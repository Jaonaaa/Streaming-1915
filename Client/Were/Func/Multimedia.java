package Were.Func;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

public class Multimedia {

    public Multimedia() {

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

    public void tranferingData(File old, File newFile) {
        Path path = Paths.get(old.getAbsolutePath());
        int divider = 10;
        try {
            byte[] bytes = Files.readAllBytes(path);
            ByteBuffer byteBuff = ByteBuffer.wrap(bytes);
            Vector<byte[]> bytesList = new Vector<byte[]>();
            for (int i = 0; i < divider; i++) {
                bytesList.add(new byte[bytes.length / divider]);
            }
            for (int i = 0; i < bytesList.size(); i++) {
                byteBuff.get(bytesList.get(i), 0, bytesList.get(i).length);
            }
            for (int i = 0; i < bytesList.size(); i++) {
                if (i > 0) {
                    transfertByte(newFile, bytesList.get(i), true);

                } else {
                    transfertByte(newFile, bytesList.get(i), false);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
