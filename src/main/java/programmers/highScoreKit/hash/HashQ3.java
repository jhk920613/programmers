package programmers.highScoreKit.hash;

import java.util.*;

// 위장
public class HashQ3 {

    public static void main(String[] args) {

        String[][] clothes = new String[][] {
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
        };

        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {

        Map<String, Integer> clothesCount = new HashMap<>();

        for (String[] clothe : clothes) {
            String type = clothe[1];
            clothesCount.put(type, clothesCount.getOrDefault(type, 0) + 1);
        }

        int answer = 1;

        for(Integer count : clothesCount.values()) {
            answer *= count + 1;
        }

        return answer - 1;
    }

}
