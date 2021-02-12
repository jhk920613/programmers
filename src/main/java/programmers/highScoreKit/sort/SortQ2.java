package programmers.highScoreKit.sort;

import util.CodeUtil;

import java.util.*;

// 가장 큰 수
public class SortQ2 {

    public static void main(String[] args) {
//        int[] numbers = {6, 10, 2};
        int[] numbers = {3, 30, 34, 5, 9};


        // 6210
        // 9534330
        System.out.println(solution(numbers));

    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] sNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(sNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -((o1 + o2).compareTo(o2 + o1));
            }
        });

        for (String number: sNumbers) {
            answer += number;
        }

        if(answer.startsWith("0")) {
            return "0";
        }

        return answer;
    }

}
