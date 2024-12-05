package java8;

interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car implements Vehicle {
    // Inherits the default method from Vehicle
}

public class DefaultMethodInInterfaceExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start(); // Outputs: Vehicle is starting
    }
}
