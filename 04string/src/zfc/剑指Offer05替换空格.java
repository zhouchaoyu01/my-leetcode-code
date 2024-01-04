package zfc;

/**
 * @author ChanceZhou
 * @code this file2022-01-23-19:32
 */
public class 剑指Offer05替换空格 {
    static class Solution {
        public String replaceSpace(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    sb.append("  ");
                }
            }
            if (sb.length() == 0) {
                return s;
            }

            int OldSize = s.length();
            System.out.println(OldSize);
            s = s + sb;
            int NewSize = s.length();
            System.out.println(NewSize);
            char[] chars = s.toCharArray();
            System.out.println(new String(chars) + "!");
            //i右指针：指向扩展字符串的最后一个位置
            //j左指针：指向原始字符串最后一个位置
            for (int i = NewSize - 1, j = OldSize - 1; j < i; i--, j--) {
                if (chars[j] != ' ') {
                    chars[i] = chars[j];
                } else {
                    chars[i] = '0';
                    chars[i - 1] = '2';
                    chars[i - 2] = '%';
                    i -= 2;
                }
            }
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.replaceSpace("we are family");
        System.out.println(s);

    }
}
