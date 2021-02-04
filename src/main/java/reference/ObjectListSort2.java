package reference;

import java.util.*;

/**
 * 객체 리스트를 정렬하는 방법 2
 * Collections.sort 인자에 Comparator 객체를 구현해서 정렬
 * compare 구현
 */
public class ObjectListSort2 {

    public static void main(String[] args) {

        // List를 선언과 동시에 초기화 하는 방법 Arrays.asList 를 사용
        List<People> peoples = new ArrayList<>(Arrays.asList(
                new People("기억", 7),
                new People("디귿", 2),
                new People("시옷", 1),
                new People("니은", 1),
                new People("비읍", 5),
                new People("미음", 6)
        ));

        // Collections.sort 인자에 Comparator 객체를 구현
        Collections.sort(peoples, new Comparator<People>() {
            @Override
            public int compare(People p1, People p2) {
                // 왼쪽이 작을 때 값이 -1 이면 오름차순
                // 왼쪽이 작을 때 값이 1 이면 내림차순
                if(p1.age < p2.age) {
                    return -1;
                } else if(p1.age.equals(p2.age)) {
                    // 같은 경우의 추가 비교 로직 추가
                    if(p1.name.compareTo(p2.name) < 0) {
                        return -1;
                    } else if(p1.name.equals(p2.name)) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });

        for(People people : peoples) {
            System.out.println(people.toString());
        }
        System.out.println();

        // 순서 뒤집기
        Collections.reverse(peoples);
        for(People people : peoples) {
            System.out.println(people.toString());
        }
    }

    static class People {
        //  public int age 으로 처리해서 객체.age 으로 접근하는 것과 private int age 후 getter/setter 을 활용하는 것이 나은가
        public String name;
        public Integer age;

        public People(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return String.format("[name]: %s / [age]: %s", this.name, this.age);
        }
    }
}