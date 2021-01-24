package codility.lesson7;

import java.util.Stack;

public class Nesting {

    public static void main(String[] args) {
        System.out.println(solution( "(()(())())"));
        System.out.println(solution( "())"));
    }

    public static int solution(String S) {
        // write your code in Java SE 8
        Stack<String> stack = new Stack<String>();

        for(int i = 0; i < S.length(); i++) {
            String cStr = S.substring(i, i+1);

            if(cStr.equals("(")) {
                stack.push(cStr);
            } else {
                if(stack.empty()) {
                    return 0;
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.empty()) {
            return 1;
        } else {
            return 0;
        }
    }

}
