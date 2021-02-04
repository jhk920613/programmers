package programmers.highScoreKit.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class GreedyQ1 {

    public static void main(String[] args) {

        int n = 5;  // 전체 학생의 수
        int[] lost = new int[]{2, 4};   // 체육복을 잃어버린 학생
        int[] reverse = new int[]{1, 3, 5}; //여벌을 챙겨온 학생

//        int n = 5;  // 전체 학생의 수
//        int[] lost = new int[]{2, 4};   // 체육복을 잃어버린 학생
//        int[] reverse = new int[]{3}; //여벌을 챙겨온 학생

//        int n = 3;  // 전체 학생의 수
//        int[] lost = new int[]{3};   // 체육복을 잃어버린 학생
//        int[] reverse = new int[]{1}; //여벌을 챙겨온 학생


//    5
        System.out.println(solution(n, lost, reverse));

    }

    // 앞 뒤 번호 학생에게만 빌려줄 수 있다.
    // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
    // 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            students.add(new Student());
        }

        for (int k : lost) {
            students.get(k - 1).minusClothes();
        }

        for (int j : reserve) {
            students.get(j - 1).plusClothes();
        }


        for (int i = 0; i < n; i++) {
            int befIndex = i - 1;
            int aftIndex = i + 1;

            if (students.get(i).clothes != 2) {
                continue;
            }

            if (befIndex >= 0 && students.get(befIndex).clothes == 0) {
                students.get(befIndex).plusClothes();
                students.get(i).minusClothes();
            } else if (aftIndex < n && students.get(aftIndex).clothes == 0) {
                students.get(i).minusClothes();
                students.get(aftIndex).plusClothes();
            }
        }

//        System.out.println(students.toString());
        answer = students.stream().filter(row -> row.clothes != 0).collect(Collectors.toList()).size();
        return answer;
    }

    static class Student {
        public int clothes = 1;

        public void minusClothes() {
            this.clothes -= 1;
        }

        public void plusClothes() {
            this.clothes += 1;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "clothes=" + clothes +
                    '}';
        }
    }

}
