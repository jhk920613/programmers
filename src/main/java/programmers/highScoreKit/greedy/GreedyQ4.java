package programmers.highScoreKit.greedy;

import util.GsonUtil;

import java.util.*;

public class GreedyQ4 {

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        GsonUtil.toJsonPrint(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        LinkedList<Integer> link = new LinkedList<>();
        for (int peo : people) {
            link.add(peo);
        }

        while (!link.isEmpty()) {
            Integer peo1 = link.removeLast();

            if(!link.isEmpty() && peo1 + link.getFirst() <= limit) {
                link.removeFirst();
            }

            answer++;
        }

        return answer;
    }

}
