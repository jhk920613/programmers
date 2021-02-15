package programmers.highScoreKit.bruteForce;

import java.util.*;

// 소수 찾기
public class BruteForceQ2 {

    public static void main(String[] args) {
//        String numbers = "17";
        String numbers = "011";

        // 3
        // 2
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;

        String[] sNumbers = new String[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            sNumbers[i] = String.valueOf(numbers.charAt(i));
        }

        Set<Integer> set = new HashSet<>();
        boolean[] visit = new boolean[sNumbers.length];

        dfs(0, visit, sNumbers, set, "");
//        GsonLibrary.toJson(set);

        answer = checkDecimal(set);
        return answer;
    }

    public static void dfs(int depth, boolean[] visit, String[] sNumbers, Set<Integer> set, String value) {
        if (!"".equals(value)) {
            set.add(Integer.parseInt(value));
        }
        if(depth == sNumbers.length) {
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, visit, sNumbers, set, value + sNumbers[i]);
                visit[i] = false;
            }
        }
    }

    public static int checkDecimal(Set<Integer> set) {
        int retValue = 0;
        for(Object val : set.toArray()) {
            int iValue = (int) val;
            int count = 0;

            // 2를 제외한 짝수는 무조건 소수가 아니다.
            if(iValue != 2 && iValue % 2 == 0) {
                continue;
            }

            for (int i = 1; i <= iValue; i++) {
                if(iValue % i == 0) {
                    count++;
                }
            }

            if(count == 2) {
                retValue++;
            }
        }

        return retValue;
    }
}
