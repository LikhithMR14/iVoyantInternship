import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        for(int i=0;i<5;i++ ) {
//            System.out.println("I will be the best Java Backend Developer");
//        }
//        final int NUMBER=100;
//        NUMBER=101;

//        Integer i=100;
//        int j=i;

//        char i='A';
//        int res=(int)i;
//        System.out.println(res);

//        Integer num=100;
//        String str=Integer.toString(num);
//        System.out.println(str.getClass().getName());

//        List<Integer> arr= List.of(9,8,7,6,4,3,2,1,0);
//        Iterator<Integer> it=arr.iterator();
//
//        while(it.hasNext()) {
//            System.out.println("Element is :" + it.next());
//        }

        for(int i=0;i<5;i++) {
            outerLoop:
            for(int j=0;j<5;j++) {
                for(int k=0;k<5;k++) {
                    if(k==3)
                        break outerLoop;
                    System.out.println(i +" " + j + " " + k);
                }
            }
        }


    }
}



