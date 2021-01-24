package codility.lesson11;

import java.util.HashMap;
import java.util.Map;

public class CountNonDivisible {
    public static void main(String[] args) {

    }

    public int[] solution(int[] A) {
        int N = A.length;
        int[] count = new int[2*N + 1];
        for(int i = 0; i < N; i++) {
            count[A[i]]++;
        }

        int[] result = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = 1; j <= Math.sqrt(A[i]); j++) {
                if(A[i] % j == 0) {
                    result[i] += count[j];

                    // 제곱 수가 아니면 루트 씌운값보다 큰값이 약수로 들어간다는 내용
                    if(A[i] / j != j) {
                        result[i] += count[A[i]/j];
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            result[i] = N - result[i];
        }

        return result;
    }

    public int[] solution2(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < N; i++) {
            int check = A[i];
            if(map.containsKey(check)) {
                result[i] = map.get(check);
            } else {
                int count = 0;
                for(int j = 0; j < N; j++) {
                    if(check % A[j] != 0) {
                        count++;
                    }
                }
                map.put(check, count);
                result[i] = count;
            }
        }

        return result;
    }
}
