package programmers.highScoreKit.stackQueue;

import java.util.*;

// 주식 가격
public class StackQueueQ1 {

    public static void main(String[] args) {

        int[] prices = new int[]{1, 2, 3, 2, 3};

        int[] answer = solution(prices);

        // [4, 3, 1, 1, 0]
        for(int ans : answer) {
            System.out.println(ans);
        }

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack;

        for (int i = 0; i < prices.length; i++) {
            stack = new Stack<>();
            int price = prices[i];

            for (int j = i + 1; j < prices.length; j++) {
                stack.push(prices[j]);

                if(price > prices[j]) {
                    break;
                }
            }

            answer[i] = stack.size();
        }

        return answer;
    }

}
