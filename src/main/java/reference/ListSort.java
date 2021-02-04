package reference;
import java.util.*;

public class ListSort {

    public static void main(String[] args) {

        List<String> listS = new ArrayList<>();
        listS.add("1");
        listS.add("3");
        listS.add("4");
        listS.add("2");
        listS.add("5");

        System.out.println(listS);

        /**
         * 오름차순 정렬
         * Collections 를 사용
         */
        Collections.sort(listS);

        System.out.println(listS);

        /**
         * 내림차순 정렬
         */
//        Collections.sort(listS, Collections.reverseOrder());  // 방법1
        listS.sort(Collections.reverseOrder()); // 방법2, 이 방법이 나음
        System.out.println(listS);

    }

}