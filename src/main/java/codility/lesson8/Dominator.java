package codility.lesson8;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1}));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        int N = A.length;
        // int compare = N % 2 == 1 ? N / 2 + 1 : N / 2;
        int compare = N / 2 + 1;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < A.length; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }

            if(map.get(A[i]) >= compare) {
                // return A[i];
                return i;
            }
        }

        return -1;

    }

}
