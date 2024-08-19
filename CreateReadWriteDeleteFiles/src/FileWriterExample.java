import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("example.txt")) {
            writer.write("Hello, World!\n");
            writer.write("My name is Likhith Siddharth M R");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
