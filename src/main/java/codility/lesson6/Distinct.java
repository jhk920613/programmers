package codility.lesson6;

import java.util.HashMap;
import java.util.Map;

public class Distinct {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1}));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < N; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        int answer = map.size();

        return answer;
    }

}
