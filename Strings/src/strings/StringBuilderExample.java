package strings;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Original String: " + sb);

        sb.append(" World");
        System.out.println("After Appending: " + sb);

        sb.insert(6, "Java ");
        System.out.println("After Inserting: " + sb);

        sb.delete(5, 8);
        System.out.println("After Deleting: " + sb);

        sb.replace(6, 7, "Programming");
        System.out.println("After Replacing: " + sb);

        System.out.println(sb.reverse());

        System.out.println(sb.compareTo(new StringBuilder("Programming")));
    }
}
