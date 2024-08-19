//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ExceptionHandlingTwoExceptionsInOneTryBlock {
    public static void main(String[] args) {
        try {
            int[] array = new int[5];
            array[10] = 30;  // ArrayIndexOutOfBoundsException
            int result = 10 / 0;  // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error occurred: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        }
    }
}
