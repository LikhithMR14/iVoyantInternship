import java.io.Serializable;

public class MyClass implements Serializable {
    private static final long serialVersionUID = 1L; // Optional, but recommended

    private int id;
    private String name;

    // Constructors, getters, setters
    public MyClass(int id,String name) {
        this.id=id;
        this.name=name;
    }

    public String getName() {
        return this.name;
    }
}
