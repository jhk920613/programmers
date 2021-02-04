package reference;

import java.util.*;

/**
 * 객체에 정렬을 하고자 할 경우
 * 1. Comparable 을 implements
 * 2. compareTo를 @Override 구현
 */
public class ObjectArraySort {

    public static void main(String[] args) {

        People[] peoples = {
                new People("기억", 7),
                new People("디귿", 2),
                new People("시옷", 1),
                new People("니은", 1),
                new People("비읍", 5),
                new People("미음", 6)
        };

        Arrays.sort(peoples);

        for (int i = 0; i < peoples.length; i++) {
            System.out.println(peoples[i].toString());
        }
    }

    static class People implements Comparable<People> {

        private final String name;
        private final Integer age;

        public People(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return String.format("[name]: %s / [age]: %s", this.name, this.age);
        }

        @Override
        public int compareTo(People people) {

            // 왼쪽이 작을 때 값이 -1 이면 오름차순
            // 왼쪽이 작을 때 값이 1 이면 내림차순
            if(this.age < people.age) {
                return -1;
            } else if(this.age.equals(people.age)) {
                // 같은 경우의 추가 비교 로직 추가
                if(this.name.compareTo(people.name) < 0) {
                    return -1;
                } else if(this.name.equals(people.name)) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }

        }
    }
}