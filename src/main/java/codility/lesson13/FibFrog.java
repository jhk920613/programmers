package codility.lesson13;

import java.util.HashMap;
import java.util.Map;

public class FibFrog {
    final static Map<Integer, Integer> fiboMap = new HashMap<>();

    public static void main(String[] args) {

//        System.out.println(fib(1));
//        System.out.println(fib(2));
//        System.out.println(fib(3));
//        System.out.println(fib(4));
//        System.out.println(fib(5));
//        System.out.println(fib(6));
//        System.out.println(fib(7));
        //    A[0] = 0
        //    A[1] = 0
        //    A[2] = 0
        //    A[3] = 1
        //    A[4] = 1
        //    A[5] = 0
        //    A[6] = 1
        //    A[7] = 0
        //    A[8] = 0
        //    A[9] = 0
        //    A[10] = 0
        solution(new int[]{
                0,
                0,
                0,
                1,
                1,
                0,
                1,
                0,
                0,
                0,
                0,
        });
    }

    public static void solution(int[] A) {
        // write your code in Java SE 8
        int start = -1;
        int end = A.length;

        int M = 0;
        while(fib(M) <= end) {
            M++;
        }
        M--;

        System.out.println(M + " / "+   fiboMap.get(M).toString());
    }

    public static int fib(int M) {
        if(M == 0) {
            return 0;
        } else if(M == 1) {
            return 1;
        }

        if(fiboMap.containsKey(M)) fiboMap.get(M);
        else fiboMap.put(M, fib(M - 1) + fib(M - 2));
        return fiboMap.get(M);
    }

    public static int fib2(int M) {
        if(M == 0) {
            return 0;
        } else if(M == 1) {
            return 1;
        }

        return fib(M - 1 ) + fib(M - 2);
    }

}
