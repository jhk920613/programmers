package reference;

import java.util.*;

/**
 * 객체 리스트를 정렬하는 방법 1
 * Comparable 인터페이스를 구현하는 요소를 가지는 리스트
 * compareTo 구현
 */
public class ObjectListSort1 {

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

        // People 객체에 Comparable 인터페이스가 이미 구현되어 있으므로 그냥 Collections 에서 sort
        Collections.sort(peoples);

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

    static class People implements Comparable<People> {

        // 게터 세터를 쓰려면 final을 뺀다
        // final을 쓰는 이유 :
        private String name;
        private Integer age;

        public People(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return String.format("[name]: %s / [age]: %s", this.name, this.age);
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public int compareTo(People people) {

            // 왼쪽이 작을 때 값이 -1 이면 오름차순
            // 왼쪽이 작을 때 값이 1 이면 내림차순
            if(this.age < people.getAge()) {
                return -1;
            } else if(this.age.equals(people.getAge())) {
                // 같은 경우의 추가 비교 로직 추가
                if(this.name.compareTo(people.getName()) < 0) {
                    return -1;
                } else if(this.name.equals(people.getName())) {
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