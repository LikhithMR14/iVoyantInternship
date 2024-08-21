import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        byte[] data = {65, 66, 67, 68};  // ASCII codes for A, B, C, D

        try (FileOutputStream fos = new FileOutputStream("CreateReadWriteDeleteFiles\\output.bin")) {
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
