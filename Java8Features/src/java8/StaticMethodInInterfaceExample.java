package java8;

interface MathOperations {
    static int add(int a, int b) {
        return a + b;
    }
}

public class StaticMethodInInterfaceExample {
    public static void main(String[] args) {
        int result = MathOperations.add(5, 10); // Outputs: 15
        System.out.println(result);
    }
}
