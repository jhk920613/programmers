package programmers.highScoreKit.bruteForce;

import reference.GsonUtil;

// 카펫
public class BruteForceQ3 {

    public static void main(String[] args) {
//        int brown = 10;
//        int yellow = 2;

//        int brown = 8;
//        int yellow = 1;

        int brown = 24;
        int yellow = 24;

        // [4,3]
        // [3,3]
        // [8,6]
        GsonUtil.printToSon(solution(brown, yellow));

    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};

        for (int i = yellow; i >= 1; i--) {
            if(yellow % i == 0) {

                int width = i + 2;
                int height = (yellow / i) + 2;

                int tile = width * height;

                if(tile == brown + yellow) {
                    answer = new int[]{width, height};
                    break;
                }
            }
        }

        return answer;
    }
}
