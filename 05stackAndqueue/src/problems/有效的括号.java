package problems;

import java.util.Stack;

/**
 * @author ChanceZhou
 * @code this file2022-02-05-18:38
 */
public class 有效的括号 {
    static class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 != 0) return false;
            Stack<Character> stack = new Stack<>();
            char[] str = s.toCharArray();
            for (int i = 0; i < str.length; i++) {
                if (str[i] == '(') stack.push(')');
                else if (str[i] == '{') stack.push('}');
                else if (str[i] == '[') stack.push(']');
                else if (stack.isEmpty() || stack.peek() != str[i])
                    return false;
                else {
                    stack.pop();
                }
            }

            return stack.isEmpty();
        }
    }


    public static void main(String[] args) {
        String s = "(){}[[]}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}
