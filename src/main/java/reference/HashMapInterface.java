package reference;

import java.util.*;

/**
 * HashMap은 hashing을 사용하기 때문에 많은 양의 데이터를 검색하는데 뛰어난 성능
 *  - key와 value를 묶어 하나의 Entry로 저장한다.
 *  - key 값은 중복이 불가능하다.
 *  - value 값은 중복과 null 값이 가능하다.
 *  - Map의 순서를 보장하지 않는다.
 */
public class HashMapInterface {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("key1", "value1");
        System.out.println(map);

        // Map 에 저장되어 있는 값을 전부 삭제
        map.clear();
        System.out.println(map);

        map.put("key1", "value3");
        map.put("key3", "value5");
        map.put("key2", "value1");

        // Map에 저장되어 있는 key, value를 엔트리(키와 값을 결합) 형태로 Set에 저장해 반환
        Set entrySet = map.entrySet();
        System.out.println(entrySet);

        // Map에 저장되어 있는 모든 key가 저장된 Set 반환
        Set keySet = map.keySet();
        System.out.println(keySet);

        // Iterator 사용
        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Map 을 value 값으로 정렬
        // entrySet을 사용함
        List<Map.Entry<String, String>> entryList = new ArrayList<>(entrySet);
        Collections.sort(entryList, new Comparator<Map.Entry<String, String>>() {

            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                if(o1.getValue().compareTo(o2.getValue()) < 0) {
                    return -1;
                } else if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        System.out.println(entryList);

    }

}