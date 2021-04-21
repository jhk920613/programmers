package programmers.level2;

import util.GsonUtil;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/60058
public class ParenthesisConversion {

    public static void main(String[] args) {
        ParenthesisConversion q = new ParenthesisConversion();

//        String p = "(()())()";
//        String p = ")(";
        String p = "()))((()";

        // "(()())()"
        // "()"
        // "()(())()"
        GsonUtil.toJsonPrint(q.solution(p));
    }

    public String solution(String p) {
        String answer = "";

        answer = makeUV(p);

        return answer;
    }

    // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    public String makeUV(String w) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if("".equals(w)) {
            return "";
        }

        int leftCount = 0;  // ( 갯수 체크
        int rightCount = 0; // ) 갯수 체크
        Stack<String> stack = new Stack<>();    // 올바른 괄호 문자열인지 체크하는 스택
        boolean flag = false;   // 처음 균형잡힌 문자열이 완성될 때 문자열이 올바론 괄호 문자열인지 체크

        int index = -1;
        for (int i = 0; i < w.length(); i++) {
            if(w.charAt(i) == '(') {    // (인 경우
                stack.push("(");
                leftCount++;
            } else {    // )인 경우
                // 스택의 꼭대기가 (일 땐 스택을 pop
                if(!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                } else {    // 스택의 꼭대기가 )이면 push
                    stack.push(")");
                }
                rightCount++;
            }

            // leftCount == rightCount 면 처음 균형잡힌 문자열이 완성된 시점
            // u를 얻기 위해서라 index == -1 도 조건을 같이 걸어줘 한번만 체크되어야 함
            if(leftCount != 0 && index == -1 && leftCount == rightCount) {
                index = i;
                if(stack.isEmpty()) { // 이 때 스택이 비어있으면 올바른 문자열
                    flag = true;
                }
            }
        }

        if(stack.isEmpty()) {   // 스택이 비어있으면 올바른 문자열이므로 그대로 리턴
            return w;
        } else {
            // 그렇지 않으면 처음으로 균형잡힌 문자열이 완성된 시점에서 u 와 v 를 생성
            String u = w.substring(0, index+1);
            String v = w.substring(index+1);

            // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
            //  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            if(flag) {
                return u + makeUV(v);
            } else {
                // 올바른 문자열이 아니라면
                // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
                // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
                // 4-3. ')'를 다시 붙입니다.
                StringBuilder result = new StringBuilder("(" + makeUV(v) + ")");

                // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
                for (int i = 1; i < u.length()-1; i++) {
                    if(u.charAt(i) == '(') {
                        result.append(")");
                    } else {
                        result.append("(");
                    }
                }

                // 4-5. 생성된 문자열을 반환합니다.
                return result.toString();
            }
        }
    }

}
