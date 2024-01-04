package problems;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author ChanceZhou
 * @code this file2022-02-05-19:10
 */
public class 删除字符串中的所有相邻重复项 {
    static class Solution {
        public String removeDuplicates(String S) {
            //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
            //参考：https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
            ArrayDeque<Character> deque = new ArrayDeque<>();
            char ch;
            for (int i = 0; i < S.length(); i++) {
                ch = S.charAt(i);
                if (deque.isEmpty() || deque.peek() != ch) {
                    deque.push(ch);
                } else {
                    deque.pop();
                }
            }
            String str = "";
            //剩余的元素即为不重复的元素
            while (!deque.isEmpty()) {
                str = deque.pop() + str;
            }
            return str;
        }
    }

    public static void main(String[] args) {
        String s = "abbaca";
        String s1 = new Solution().removeDuplicates(s);
        System.out.println(s1);
    }
}
