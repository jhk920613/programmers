package programmers.highScoreKit.bruteForce;
import util.GsonUtil;

import java.util.*;

// 모의고사
public class BruteForceQ1 {

    public static void main(String[] args) {

//        int[] answers = {1,2,3,4,5};
        int[] answers = {1,3,2,4,2};

        // [1]
        // [1,2,3]
        GsonUtil.toJsonPrint(solution(answers));
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};

        List<Supoja> supojas = new ArrayList<>();
        supojas.add(new Supoja(1, new int[]{1, 2, 3, 4, 5}, answers));
        supojas.add(new Supoja(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}, answers));
        supojas.add(new Supoja(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, answers));

        int max = -1;
        List<Integer> lAnswer = new ArrayList<>();
        for (Supoja supoja : supojas) {
            if (supoja.getCorrect() > max) {
                lAnswer = new ArrayList<>();
                lAnswer.add(supoja.getId());
                max = supoja.getCorrect();
            } else if (supoja.getCorrect() == max) {
                lAnswer.add(supoja.getId());
            }
        }

        answer = new int[lAnswer.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = lAnswer.get(i);
        }

        return answer;
    }

    public static class Supoja {
        private final int id;
        private final int correct;

        public Supoja(int id, int[] pattern, int[] answers) {
            this.id = id;
            this.correct = countCorrect(pattern,answers);
        }

        public int countCorrect(int[] pattern, int[] answers) {
            int correct = 0;

            for (int i = 0; i < answers.length; i++) {
                if(answers[i] == pattern[i % pattern.length]) {
                    correct++;
                }
            }

            return correct;
        }

        public int getId() {
            return id;
        }

        public int getCorrect() {
            return correct;
        }
    }
}
