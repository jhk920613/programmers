package programmers.highScoreKit.dfsBfs;

import util.GsonUtil;

import java.util.*;

public class DfsBfsQ1 {

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        //5
        GsonUtil.toJsonPrint(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        dfs(0, numbers, target, list, 0);

        answer = list.size();

        return answer;
    }

    public static void dfs(int depth, int[] numbers, int target, List<Integer> list, int value) {
        if(depth == numbers.length) {
            if(value == target) {
                list.add(value);
            }
            return;
        }

        dfs(depth+1, numbers, target, list, value + numbers[depth]);
        dfs(depth+1, numbers, target, list, value - numbers[depth]);

    }
}
