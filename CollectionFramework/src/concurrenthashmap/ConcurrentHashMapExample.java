package concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        // Creating a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 1. put(K key, V value) - Adding key-value pairs
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);
        System.out.println("ConcurrentHashMap after put(): " + map);

        // 2. get(Object key) - Retrieving a value
        int value = map.get("Banana");
        System.out.println("Value associated with 'Banana': " + value);

        // 3. putIfAbsent(K key, V value) - Add only if key is not already present
        map.putIfAbsent("Banana", 4); // This won't replace the existing value for "Banana"
        map.putIfAbsent("Date", 4);   // This will add the new key-value pair
        System.out.println("ConcurrentHashMap after putIfAbsent(): " + map);

        // 4. remove(Object key) - Removing a key-value pair
        map.remove("Apple");
        System.out.println("ConcurrentHashMap after remove(): " + map);

        // 5. replace(K key, V value) - Replacing a value
        map.replace("Cherry", 5);
        System.out.println("ConcurrentHashMap after replace(): " + map);

        // 6. replace(K key, V oldValue, V newValue) - Conditional replace
        boolean replaced = map.replace("Date", 4, 6);
        System.out.println("Was 'Date' replaced? " + replaced);
        System.out.println("ConcurrentHashMap after conditional replace(): " + map);

        // 7. containsKey(Object key) - Checking for a key
        boolean containsCherry = map.containsKey("Cherry");
        System.out.println("Does the map contain 'Cherry'? " + containsCherry);

        // 8. containsValue(Object value) - Checking for a value
        boolean containsValue6 = map.containsValue(6);
        System.out.println("Does the map contain value 6? " + containsValue6);
    }
}

