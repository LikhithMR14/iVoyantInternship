import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("CreateReadWriteDeleteFiles\\output.bin")) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print((char)byteData + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
