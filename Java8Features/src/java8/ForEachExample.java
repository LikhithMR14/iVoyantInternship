package java8;

import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using forEach with a lambda expression
        names.forEach(name -> System.out.println(name));

        // Using forEach with a method reference
        names.forEach(System.out::println);
    }
}
