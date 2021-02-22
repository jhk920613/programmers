package backjun;

import java.util.*;

public class Q2579 {

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        int answer = solution(N, number);
        System.out.println(answer);
    }

    private static int tmp_answer = -1;

    public static int solution(int N, int number) {
        int answer = 0;

        List<List<Integer>> dpList = new ArrayList<>();
        List<Integer> dp = null;

        dp = new ArrayList<>();
        dpList.add(dp);
        dp.add(N);
        dpList.add(dp);

        if (N == number) {
            answer = 1;
            return answer;
        }

        for (int i = 2; i <= 8; i++) {
            dp = new ArrayList<>();
            dp.add(getF(N, i));

            if (getF(N, i) == number) {
                tmp_answer = i;
                break;
            }

            for (int j = 1; j < i; j++) {
                List<Integer> tmp1 = dpList.get(j);
                List<Integer> tmp2 = dpList.get(i - j);

                for (int k = 0; k < tmp1.size(); k++) {
                    for (int p = 0; p < tmp2.size(); p++) {
                        addDp(dp, tmp1.get(k), tmp2.get(p), number, i);
                        if (tmp_answer != -1) break;
                    }
                    if (tmp_answer != -1) break;
                }
                if (tmp_answer != -1) break;
            }
            if (tmp_answer != -1) break;
            dpList.add(dp);
        }

        answer = tmp_answer;
        return answer;
    }

    public static void addDp(List<Integer> dp, int front, int after, int number, int i) {
        if (front + after == number) {
            tmp_answer = i;
        }
        if (front - after == number) {
            tmp_answer = i;
        }
        if (front * after == number) {
            tmp_answer = i;
        }

        if (after != 0) {
            if (front / after == number) {
                tmp_answer = i;
            }
        }

        dp.add(front + after);
        dp.add(front - after);
        dp.add(front * after);
        if (after != 0) {
            dp.add(front / after);
        }
    }

    public static int getF(int N, int i) {
        String f = "";
        for (int index = 0; index < i; index++) {
            f += String.valueOf(N);
        }

        return Integer.parseInt(f);
    }

}