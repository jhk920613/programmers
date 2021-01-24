package programmers.HighScoreKit.Hash;

import java.util.*;

// 완주하지 못한 선수
public class Q1 {

    public static void main(String[] args) {
        String[] participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[]{"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if(!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }

        return participant[participant.length - 1];
    }

}
