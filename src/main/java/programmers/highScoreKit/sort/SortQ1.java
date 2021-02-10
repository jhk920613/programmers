package programmers.highScoreKit.sort;

import java.util.*;

public class SortQ1 {

    // K 번째 수
    public static void main(String[] args) {

        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{
                {2, 5, 3},{4, 4, 1},{1, 7, 3}
        };

        int[] solution = solution(array, commands);

        // [5, 6, 3]
        for (int arr : solution) {
            System.out.println(arr);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tmpArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tmpArray);
            answer[i] = tmpArray[commands[i][2] - 1];
        }

        return answer;
    }

}
