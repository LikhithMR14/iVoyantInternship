// Custom Checked Exception
class MyCustomCheckedException extends Exception {
    // Default constructor
    public MyCustomCheckedException() {
        super();
    }

    // Constructor with a message
    public MyCustomCheckedException(String message) {
        super(message);
    }

}

// Custom Unchecked Exception
class MyCustomUncheckedException extends RuntimeException {
    // Default constructor
    public MyCustomUncheckedException() {
        super();
    }

    // Constructor with a message
    public MyCustomUncheckedException(String message) {
        super(message);
    }

}

// Class that uses the custom exceptions
class MyClass {
    // Method that throws a custom checked exception
    public void methodWithCheckedException() throws MyCustomCheckedException {
        // Simulate some logic
        boolean someCondition = true; // This would be some actual condition in a real scenario
        if (someCondition) {
            throw new MyCustomCheckedException("Custom checked exception occurred");
        }
    }

    // Method that throws a custom unchecked exception
    public void methodWithUncheckedException() {
        // Simulate some logic
        boolean someCondition = true; // This would be some actual condition in a real scenario
        if (someCondition) {
            throw new MyCustomUncheckedException("Custom unchecked exception occurred");
        }
    }
}

// Main class to test the exceptions
public class CustomException {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        // Handle the custom checked exception
        try {
            myClass.methodWithCheckedException();
        } catch (MyCustomCheckedException e) {
            System.out.println("Caught custom checked exception: " + e.getMessage());
        }

        // Handle the custom unchecked exception
        try {
            myClass.methodWithUncheckedException();
        } catch (MyCustomUncheckedException e) {
            System.out.println("Caught custom unchecked exception: " + e.getMessage());
        }
    }
}
