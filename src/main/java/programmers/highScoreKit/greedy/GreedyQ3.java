package programmers.highScoreKit.greedy;

// 큰 수 만들기
public class GreedyQ3 {

    public static void main(String[] args) {

//        String number = "1924";
//        int k = 2;Ò
//        94

//        String number = "1231234";
//        int k = 3;
//        3234

        String number = "4177252841";
        int k = 4;
//        775841

        System.out.println(solution(number, k));
    }

    /**
     * number : 1231234 / k : 3 이면
     * 결과가 되는 answer 의 길이는 4여야 한다.
     * while 루프를 돌 때마다 answer 는 한글자씩 추가되고 remain 의 길이는 하나씩 줄어든다.
     * 7글자이므로 첫번째 while 루프를 돌때 남는 remain 은 선택될 한글자수를 제외한 3이 된다.
     *      0 ~ 3 자리의 글자들을 비교하게 된다. ( 3 = 전체글자수(7) - 남아있는 글자수(4))
     */
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int start = 0;  // 비교를 시작할 인덱스
        int remain = number.length() - k;   // 남아있는 answer 의 길이

        while(answer.length() != number.length() - k) { // answer의 길이가 원하는 길이가 될 때까지 반복
            String max = "-1";   // 초기 값 지정

            int end = number.length() - remain; // number 문자열의 길이에서 남아있는 answer 의 길이를 빼면 비교할 문자열의 범위가 지정된다.
            for (int i = start; i <= end; i++) {
                if(max.compareTo(String.valueOf(number.charAt(i))) < 0) {
                    max = String.valueOf(number.charAt(i));
                    start = i;  //max 가 될 글자의 인덱스를 저장
                }

                if(max.equals("9")) {   // 9일 경우는 비교할 필요가 없이 가장 큰 값이 돼 이후 비교가 의미가 없으므로 for 반복문을 스탑
                    break;
                }
            }

            answer.append(max);  // max 값의 글자를 answer에 붙이고
            start++;    // 그 다음 인덱스 글자부터 체크할 수 있도록 한다.
            remain--;   // answer에 한글자 늘렸으므로 남아있는 여유글자는 하나 빼기
        }

        return answer.toString();
    }
}
