package problems;

import sun.applet.Main;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ChanceZhou
 * @code this file2022-02-05-20:34
 */
public class 逆波兰表达式求值 {
    static class Solution {
        public int evalRPN(String[] tokens) {
            int second;
            int first;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i] == "+") {
                    second = (stack.pop());
                    first = (stack.pop());
                    stack.push((first + second));
                } else if (tokens[i] == "-") {
                    second = (stack.pop());
                    first = (stack.pop());
                    stack.push((first - second));
                } else if (tokens[i] == "*") {
                    second = (stack.pop());
                    first = (stack.pop());
                    stack.push((first * second));
                } else if (tokens[i] == "/") {
                    second = (stack.pop());
                    first = (stack.pop());
                    stack.push((first / second));
                } else {
                    stack.push(Integer.parseInt(tokens[i]));
                }
            }

            return (stack.pop());
        }
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = new Solution().evalRPN(tokens);
        System.out.println(i);
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}

