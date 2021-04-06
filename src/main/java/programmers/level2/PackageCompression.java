package programmers.level2;

import util.GsonUtil;

import java.util.*;

// 코딩테스트 연습 2020 KAKAO BLIND RECRUITMENT 문자열 압축
public class PackageCompression {

    public static void main(String[] args) {

        String s = "aabbaccc";  //`	7
//        String s = "a";  //`	1
//        String s = "ababcdcdababcdcd";  //`	9
//        String s = "abcabcdede";    //`	8
//        String s = "abcabcabcabcdededededede";  //`	14
//        String s = "xababcdcdababcdcd"; //`	17

        PackageCompression packageCompression = new PackageCompression();

        GsonUtil.toJsonPrint(packageCompression.solution(s));
    }

    public int solution(String s) {
        int answer = 0;

        int s_length = s.length();

        int max = s.length() / 2;

        if(max == 0) {
            return s.length();
        }

        String result = "";
        for (int mok = 1; mok <= max; mok++) {
            StringBuilder tmp_result = new StringBuilder();
            String bef = s.substring(0, mok);
            int count = 1;

            int i;
            for (i = mok; i < s_length; i+= mok) {
                if(i+mok >= s_length) {
                    break;
                }
                String cut = s.substring(i, i+mok);
                if(bef.equals(cut)) {
                    count++;

                } else {
                    tmp_result.append(count == 1 ? "" : count).append(bef);
                    count = 1;
                    bef = cut;
                }
            }


            System.out.println(s.substring(i) + " " + count + " " + bef);
            if(s.substring(i).equals(bef)) {
                tmp_result.append(count + 1).append(bef);
            } else {
                tmp_result.append(count != 1 ? count : "").append(bef).append(s.substring(i));
            }

            if("".equals(result)) {
                result = tmp_result.toString();
            } else {
                result = result.length() < tmp_result.length() ? result : tmp_result.toString();
            }
        }

        answer = result.length();

        return answer;
    }
}
