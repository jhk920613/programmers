package programmers.highScoreKit.heap;

import util.GsonUtil;

import java.util.*;

public class HeapQ3 {

    public static void main(String[] args) {
//        String[] operations = {"I 16", "D 1"};

        String[] operations = {"I 7", "I 5", "I -5", "D -1"};

        // [0,0]
        // [7,5]
        GsonUtil.toJsonPrint(solution(operations));
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> minQ = new PriorityQueue<>(Integer::compareTo);  // 자연 정렬로 지정
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((i1, i2) -> -(i1.compareTo(i2)));

        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");

            if ("I".equals(operation[0])) {
                // 큐에 값 삽입
                insertQ(minQ, maxQ, Integer.valueOf(operation[1]));
            } else {
                if (Integer.valueOf(operation[1]).compareTo(0) < 0) {
                    // 최솟값 삭제
                    deleteMin(minQ, maxQ);
                } else {
                    // 최댓값 삭제
                    deleteMax(minQ, maxQ);
                }
            }
        }

        makeResultQ(minQ, maxQ);

        if (maxQ.peek() != null && minQ.peek() != null) {
            answer = new int[]{maxQ.peek(), minQ.peek()};
        }

        return answer;
    }

    public static void makeResultQ(PriorityQueue<Integer> minQ, PriorityQueue<Integer> maxQ) {
        if (minQ.isEmpty()) {
            minQ.addAll(maxQ);
        } else {
            maxQ.addAll(minQ);
        }
    }

    public static void insertQ(PriorityQueue<Integer> minQ, PriorityQueue<Integer> maxQ, Integer value) {
        if (minQ.isEmpty()) {
            maxQ.add(value);
        } else {
            minQ.add(value);
        }
    }

    public static void deleteMin(PriorityQueue<Integer> minQ, PriorityQueue<Integer> maxQ) {
        minQ.addAll(maxQ);
        maxQ.clear();

        minQ.poll();
    }

    public static void deleteMax(PriorityQueue<Integer> minQ, PriorityQueue<Integer> maxQ) {
        maxQ.addAll(minQ);
        minQ.clear();

        maxQ.poll();
    }

}
