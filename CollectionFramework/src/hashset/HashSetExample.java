package hashset;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        // Creating a HashSet
        HashSet<String> set = new HashSet<>();

        // 1. add(E e) - Adding elements to the HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Date");
        System.out.println("HashSet after add(): " + set);

        // 2. remove(Object o) - Removing an element from the HashSet
        set.remove("Banana");
        System.out.println("HashSet after remove(): " + set);

        // 3. contains(Object o) - Checking if an element is in the HashSet
        boolean containsCherry = set.contains("Cherry");
        System.out.println("Does the HashSet contain 'Cherry'? " + containsCherry);

        // 4. isEmpty() - Checking if the HashSet is empty
        boolean isEmpty = set.isEmpty();
        System.out.println("Is the HashSet empty? " + isEmpty);

        // 5. size() - Getting the size of the HashSet
        int size = set.size();
        System.out.println("Size of the HashSet: " + size);

        // 6. iterator() - Iterating over the elements in the HashSet
        System.out.print("Iterating over HashSet: ");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 7. addAll(Collection<? extends E> c) - Adding all elements from another collection
        HashSet<String> otherSet = new HashSet<>();
        otherSet.add("Elderberry");
        otherSet.add("Fig");
        set.addAll(otherSet);
        System.out.println("HashSet after addAll(): " + set);

        // 8. removeAll(Collection<?> c) - Removing all elements that are in another collection
        set.removeAll(otherSet);
        System.out.println("HashSet after removeAll(): " + set);

        // 9. retainAll(Collection<?> c) - Retaining only elements that are in another collection
        otherSet.add("Cherry");
        set.retainAll(otherSet);
        System.out.println("HashSet after retainAll(): " + set);

        // 10. toArray() - Converting HashSet to an array
        Object[] array = set.toArray();
        System.out.print("Array from HashSet: ");
        for (Object obj : array) {
            System.out.print(obj + " ");
        }
        System.out.println();

        // 11. clear() - Clearing all elements from the HashSet
        set.clear();
        System.out.println("HashSet after clear(): " + set);

        // 12. clone() - Cloning the HashSet (shallow copy)
        HashSet<String> clonedSet = (HashSet<String>) otherSet.clone();
        System.out.println("Cloned HashSet: " + clonedSet);
    }
}

