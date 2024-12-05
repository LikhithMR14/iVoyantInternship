package strings;

public class StringMethodsExample {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";

        System.out.println(str1 == str2); // true
        System.out.println(str1.equals(str2)); // true

        String str3 = "Hello";
        String str4 = new String("Hello");

        //equals method
        System.out.println(str3 == str4); // false
        System.out.println(str3.equals(str4)); // true

        str1="Bye";
        System.out.println(str1 == str2); // false

        System.out.println(str2);
        System.out.println(str1);

//        String str="";
//        for(int i=0;i<26;i++) {
//            str += ((char)('a' + i));
//        }
//        System.out.println(str);

        //substring method
        System.out.println(str1.substring(0, 3)); // Hello
        System.out.println(str1.substring(3)); // ello
        System.out.println(str1.substring(2, 3)); // llo

        //replace method
        System.out.println(str1.replace('l', 'X')); // HeXoXlo
        System.out.println(str1); // Hello

        //concat method
        String str5 = "World";
        System.out.println(str1.concat(str5)); // HelloWorld

        //toLowerCase and toUpperCase methods
        System.out.println(str1.toLowerCase()); // hello
        System.out.println(str1.toUpperCase()); // HELLO

        //trim method
        String str6 = "  Hello World  ";
        System.out.println(str6.trim()); // Hello World

        //length method
        System.out.println(str1.length()); // 10

        //split method
        String[] words = "Hi! How are you Guys.".split(" ");
        for (String word : words) {
            System.out.println(word);
        }

        //join method
        String delimiter = ",";
        String[] names = {"John", "Doe", "Jane"};
        System.out.println(String.join(delimiter, names));

        //str.
    }
}
