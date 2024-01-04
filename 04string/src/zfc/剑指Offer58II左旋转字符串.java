package zfc;

/**
 * @author ChanceZhou
 * @code this file2022-01-28-17:15
 */
public class 剑指Offer58II左旋转字符串 {
    //思想是三次反转，但是java中效率太低，字符串为不可变
    //    class Solution {
//        public String reverseLeftWords(String s, int n) {
//            int len = s.length();
//            StringBuilder sb = new StringBuilder(s);
//            reverseWord(sb, 0, n - 1);
//            reverseWord(sb, n, len - 1);
//            return sb.reverse().toString();
//
//        }
//
//        public void reverseWord(StringBuilder sb, int start, int end) {
//            while (start < end) {
//                char temp = sb.charAt(start);
//                sb.setCharAt(start, sb.charAt(end));
//                sb.setCharAt(end, temp);
//                start++;
//                end--;
//            }
//        }
//    }
    class Solution {
        public String reverseLeftWords(String s, int n) {
            StringBuilder res = new StringBuilder();
            for (int i = n; i < n + s.length(); i++)
                res.append(s.charAt(i % s.length()));
            return res.toString();
        }
    }

}
