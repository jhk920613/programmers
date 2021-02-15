package programmers.highScoreKit.sort;

import java.util.*;

// H-Index
public class SortQ3 {

    public static void main(String[] args) {

        SortQ3 sortQ3 = new SortQ3();

//        int[] citations = {20, 19, 18, 1};
        int[] citations = {3, 0, 6, 1, 5};

        // 3
        System.out.println(sortQ3.solution(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;

        Integer[] iCitations = new Integer[n];
        for (int i = 0; i < n; i++) {
            iCitations[i] = citations[i];
        }

        Arrays.sort(iCitations, Collections.reverseOrder());

        // h의 값은 어짜피 0부터 발표한 논문의 수 사이여야 함
        for (int i = (n-1); i >= 0; i--) {
            Integer h = i + 1;
            if(iCitations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
