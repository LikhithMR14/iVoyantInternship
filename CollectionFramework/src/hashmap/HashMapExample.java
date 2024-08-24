package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // 1. put(K key, V value) - Adding key-value pairs to the HashMap
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);
        System.out.println("HashMap after put(): " + map);

        // 2. get(Object key) - Retrieving the value associated with a key
        int value = map.get("Banana");
        System.out.println("Value associated with 'Banana': " + value);

        // 3. remove(Object key) - Removing a key-value pair
        map.remove("Apple");
        System.out.println("HashMap after remove(): " + map);

        // 4. containsKey(Object key) - Checking if a key is in the map
        boolean containsCherry = map.containsKey("Cherry");
        System.out.println("Does the HashMap contain 'Cherry'? " + containsCherry);

        // 5. containsValue(Object value) - Checking if a value is in the map
        boolean containsValue2 = map.containsValue(2);
        System.out.println("Does the HashMap contain value 2? " + containsValue2);

        // 6. isEmpty() - Checking if the map is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is the HashMap empty? " + isEmpty);

        // 7. size() - Getting the size of the map
        int size = map.size();
        System.out.println("Size of the HashMap: " + size);

        // 8. putAll(Map<? extends K, ? extends V> m) - Adding all key-value pairs from another map
        HashMap<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Date", 4);
        anotherMap.put("Elderberry", 5);
        map.putAll(anotherMap);
        System.out.println("HashMap after putAll(): " + map);

        // 9. clear() - Clearing the map
        map.clear();
        System.out.println("HashMap after clear(): " + map);

        // Adding elements again to demonstrate further methods
        map.put("Fig", 6);
        map.put("Grape", 7);
        map.put("Honeydew", 8);

        // 10. keySet() - Getting a Set of keys
        Set<String> keys = map.keySet();
        System.out.println("Keys in the HashMap: " + keys);

        // 11. values() - Getting a Collection of values
        System.out.println("Values in the HashMap: " + map.values());

        // 12. entrySet() - Getting a Set of key-value pairs
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("Entries in the HashMap: ");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // 13. replace(K key, V value) - Replacing a value for a specific key
        map.replace("Grape", 9);
        System.out.println("HashMap after replace(): " + map);

        // 14. replace(K key, V oldValue, V newValue) - Replacing a value for a specific key if it matches the old value
        boolean replaced = map.replace("Honeydew", 8, 10);
        System.out.println("Was 'Honeydew' replaced? " + replaced);
        System.out.println("HashMap after conditional replace(): " + map);
    }
}

