package programmers.level2;
import util.GsonUtil;

import java.util.*;
// https://programmers.co.kr/learn/courses/30/lessons/64065
public class Tuple {

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        Tuple tuple = new Tuple();
        // [2, 1, 3, 4]
        GsonUtil.toJsonPrint(tuple.solution(s));
    }

    public int[] solution(String s) {
        int[] answer;

        String[] arr = s.substring(2, s.length()-2).replace("{", "").split("},");

        Map<Integer, Integer> map = new HashMap<>();
        for (String value : arr) {
            for (String sNum : value.split(",")) {
                Integer key = Integer.parseInt(sNum);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        answer = new int[arr.length];

        for (Integer key : map.keySet()) {
            answer[map.size() - map.get(key)] = key;
        }

        return answer;
    }
}
