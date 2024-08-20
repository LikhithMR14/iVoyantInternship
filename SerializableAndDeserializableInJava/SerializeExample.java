import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class SerializeExample {
    public static void main(String[] args) {
        MyClass obj = new MyClass(1, "Example");
        MyClass obj1=new MyClass(2,"NewExample");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objectfile.data"))) {
            out.writeObject(obj);
            out.writeObject(obj1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
