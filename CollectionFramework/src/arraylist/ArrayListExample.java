package arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<String> list = new ArrayList<>();

        // 1. add(E e)
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("List after adding elements: " + list);

        // 2. add(int index, E element)
        list.add(1, "Date");
        System.out.println("List after adding element at index 1: " + list);

        // 3. get(int index)
        String element = list.get(2);
        System.out.println("Element at index 2: " + element);

        // 4. set(int index, E element)
        list.set(2, "Elderberry");
        System.out.println("List after setting element at index 2: " + list);

        // 5. remove(int index)
        list.remove(3);
        System.out.println("List after removing element at index 3: " + list);

        // 6. remove(Object o)
        list.remove("Apple");
        System.out.println("List after removing 'Apple': " + list);

        // 7. size()
        int size = list.size();
        System.out.println("Size of the list: " + size);

        // 8. clear()
        list.clear();
        System.out.println("List after clearing all elements: " + list);

        // Re-populate the list for further examples
        list.add("Fig");
        list.add("Grape");
        list.add("Honeydew");

        // 9. isEmpty()
        boolean isEmpty = list.isEmpty();
        System.out.println("Is the list empty? " + isEmpty);

        // 10. contains(Object o)
        boolean contains = list.contains("Grape");
        System.out.println("Does the list contain 'Grape'? " + contains);

        // 11. indexOf(Object o)
        int index = list.indexOf("Honeydew");
        System.out.println("Index of 'Honeydew': " + index);

        // 12. lastIndexOf(Object o)
        list.add("Grape");
        int lastIndex = list.lastIndexOf("Grape");
        System.out.println("Last index of 'Grape': " + lastIndex);

        // 13. toArray()
        Object[] array = list.toArray();
        System.out.println("Array representation of list:");
        for (Object obj : array) {
            System.out.println(obj);
        }

        // 14. subList(int fromIndex, int toIndex)
        List<String> subList = list.subList(1, 3);
        System.out.println("Sublist from index 1 to 3: " + subList);

        // 15. addAll(Collection<? extends E> c)
        ArrayList<String> anotherList = new ArrayList<>();
        anotherList.add("Kiwi");
        anotherList.add("Lemon");
        list.addAll(anotherList);
        System.out.println("List after adding all elements from anotherList: " + list);

        // 16. retainAll(Collection<?> c)
        list.retainAll(anotherList);
        System.out.println("List after retaining only elements in anotherList: " + list);

        // 17. removeAll(Collection<?> c)
        list.add("Mango");
        list.add("Nectarine");
        list.removeAll(anotherList);
        System.out.println("List after removing all elements in anotherList: " + list);

        // 18. forEach(Consumer<? super E> action)
        System.out.println("Iterating over the list with forEach:");
        list.forEach(System.out::println);
    }
}
