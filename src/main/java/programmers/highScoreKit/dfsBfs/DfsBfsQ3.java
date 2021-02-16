package programmers.highScoreKit.dfsBfs;

import java.util.*;

// 단어 변환
public class DfsBfsQ3 {

    public static void main(String[] args) {
//        String begin = "hit";
//        String target = "cog";
//        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = words.length + 1;

        // words 안에 target 단어가 없으면 그냥 리턴
        if(Arrays.stream(words).noneMatch(word -> word.equals(target))) {
            return 0;
        }

        boolean[] visited;
        for (int i = 0; i < words.length; i++) {
            if(canChange(begin, words[i])) {
                visited = new boolean[words.length];
                answer = Math.min(answer, dfs(words[i], target, words, i, visited, 1));
            }
        }

        return answer;
    }

    public static int dfs(String begin, String target, String[] words, int i, boolean[] visited, int count) {
        if(begin.equals(target)) {
            return count;
        }

        visited[i] = true;

        int retValue = 0;
        for (int j = 0; j < words.length; j++) {
            if(!visited[j] && canChange(begin, words[j])) {
                retValue = dfs(words[j], target, words, j, visited, count+1);
            }
        }

        return retValue;
    }

    public static boolean canChange(String begin, String word) {
        int count = 0;

        for (int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) != word.charAt(i)) {
                count++;
            }
            if(count > 1) {
                return false;
            }
        }

        return count == 1;
    }

}
