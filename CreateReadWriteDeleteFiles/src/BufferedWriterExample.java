import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output1.txt"))) {
            writer.write("This is a line of text.");
            writer.newLine();  // Write a new line
            writer.write("This is another line of text.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
