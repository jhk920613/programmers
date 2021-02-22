package programmers.highScoreKit.heap;
import util.GsonUtil;

import java.util.*;

// 더 맵게
public class HeapQ1 {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        // 2
        System.out.println(GsonUtil.toJson(solution(scoville, K)));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQ = new PriorityQueue<>();
        for (int sco : scoville) {
            priorityQ.add(sco);
        }

        GsonUtil.toJsonPrint(priorityQ);
        boolean breakFlag = false;
        while (!breakFlag && priorityQ.size() > 1) {
            priorityQ.add(getScoville(priorityQ.remove(), priorityQ.remove()));

            answer++;
            if(isTheEnd(priorityQ, K)) {
                breakFlag = true;
            }
        }

        if(!isTheEnd(priorityQ, K)) {
            answer = -1;
        }

        return answer;
    }

    public static boolean isTheEnd(PriorityQueue<Integer> priorityQ, int K) {

        return priorityQ.peek() >= K;
    }

    public static int getScoville(int a, int b) {
        return a + (b * 2);
    }

}
