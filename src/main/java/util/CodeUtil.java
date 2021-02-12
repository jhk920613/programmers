package util;

public class CodeUtil {

    public static void printArray(int[] array) {
        System.out.print("[ ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i == array.length - 1) {
                break;
            }
            System.out.print(", ");
        }
        System.out.println(" ]");
    }

    public static void printArray(String[] array) {
        System.out.print("[ ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i == array.length - 1) {
                break;
            }
            System.out.print(", ");
        }
        System.out.println(" ]");
    }

    public static void printArray(Integer[] array) {
        System.out.print("[ ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i == array.length - 1) {
                break;
            }
            System.out.print(", ");
        }
        System.out.println(" ]");
    }
}
