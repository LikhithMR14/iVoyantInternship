import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class DeserializeExample {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("objectfile.data"))) {
            MyClass obj = (MyClass) in.readObject();
            MyClass obj1=(MyClass) in.readObject();
            System.out.println(obj.getName());
            System.out.println(obj1.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
