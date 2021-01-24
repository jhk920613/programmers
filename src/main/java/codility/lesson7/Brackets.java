package codility.lesson7;

import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));
        System.out.println(solution("([)()]"));
    }

    public static int solution(String S) {
        // write your code in Java SE 8

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < S.length(); i++) {
            String cStr = S.substring(i, i+1);

            if(cStr.equals("(") || cStr.equals("{") || cStr.equals("[")) {
                stack.push(cStr);
            } else {
                if(stack.empty()) {
                    return 0;
                }

                String peek = stack.peek();
                if(cStr.equals(")") && peek.equals("(")) {
                    stack.pop();
                } else if(cStr.equals("}") && peek.equals("{")) {
                    stack.pop();
                } else if(cStr.equals("]") && peek.equals("[")) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        if(stack.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
