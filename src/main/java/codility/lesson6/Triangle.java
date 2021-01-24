package codility.lesson6;

import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 2, 5, 1, 8 , 20}));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);
        for(int i = 0; i < A.length - 2; i++) {
            int AP = A[i];
            int AQ = A[i+1];
            int AR = A[i+2];

            if(isTrianguler(AP, AQ, AR)) {
                return 1;
            }
        }

        return 0;
    }


    public static boolean isTrianguler(int AP, int AQ, int AR) {
        if(AP > AR - AQ && AQ > AP - AR && AR > AQ - AP) {
            return true;
        }

        return false;
    }
}
