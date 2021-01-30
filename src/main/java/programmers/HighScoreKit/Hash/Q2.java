package programmers.HighScoreKit.Hash;

// 전화번호 목록
public class Q2 {

    public static void main(String[] args) {

        String[] phone_book = new String[]
//                {"119", "97674223", "1195524421"};  //false
//                {"123","456","789"};    // true
                {"12","123","1235","567","88"};//false
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        // phone_book의 길이는 1 이상 1,000,000 이하입니다.
        // 각 전화번호의 길이는 1 이상 20 이하입니다.
        for (int i = 0; i < phone_book.length; i++) {
            String phone = phone_book[i];
            for (int j = 0; j < phone_book.length; j++) {
                if(i == j) {
                    continue;
                }
                if(phone_book[j].startsWith(phone)) {
                    return false;
                }
            }
        }

        return true;
    }

}
