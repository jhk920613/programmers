package reference;

import java.util.*;

public class ArraySort {

    public static void main(String[] args) {

        String[] arrayS1 = new String[]{"1", "3", "4", "2", "5"};
        String[] arrayS2 = new String[]{"1", "3", "4", "2", "5"};

        /**
         * 오름차순 정렬
         */
        Arrays.sort(arrayS1);

        for(String arr: arrayS1) {
            System.out.println(arr);
        }
        System.out.println();

        /**
         * 내림차순 정렬
         */
        Arrays.sort(arrayS2, Collections.reverseOrder());
        for(String arr: arrayS2) {
            System.out.println(arr);
        }
        System.out.println();



    }


}