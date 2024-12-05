package hashtable;

import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {
    public static void main(String[] args) {
        // Creating a Hashtable
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // Adding key-value pairs to the Hashtable
        hashtable.put("Apple", 1);
        hashtable.put("Banana", 2);
        hashtable.put("Cherry", 3);

        // Attempting to add a null key or value will throw a NullPointerException
        // hashtable.put(null, 4); // Uncommenting this line will throw an exception

        // Retrieving a value using a key
        int value = hashtable.get("Banana");
        System.out.println("Value associated with 'Banana': " + value);

        // Checking if a key or value is in the Hashtable
        boolean containsApple = hashtable.containsKey("Apple");
        boolean containsValue2 = hashtable.containsValue(2);
        System.out.println("Does the Hashtable contain 'Apple'? " + containsApple);
        System.out.println("Does the Hashtable contain value 2? " + containsValue2);

        // Iterating over the keys in the Hashtable
        System.out.println("Keys in the Hashtable:");
        for (String key : hashtable.keySet()) {
            System.out.println(key + " => " + hashtable.get(key));
        }

        // Removing a key-value pair
        hashtable.remove("Apple");
        System.out.println("Hashtable after removing 'Apple': " + hashtable);
    }
}
