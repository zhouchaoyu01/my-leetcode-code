package zfc;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * <p>
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 * @author ChanceZhou
 * @code this file2022-01-23-16:18
 */
public class 反转字符串Ⅱ {

    //题目的意思其实概括为 每隔2k个反转前k个，尾数不够k个时候全部反转
    class Solution1 {
        public String reverseStr(String s, int k) {
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i += 2 * k) {
                int start = i;
                //这里是判断尾数够不够k个来取决end指针的位置
                int end = Math.min(ch.length - 1, start + k - 1);
                //用异或运算反转
                while (start < end) {
                    ch[start] ^= ch[end];
                    ch[end] ^= ch[start];
                    ch[start] ^= ch[end];
                    start++;
                    end--;
                }
            }
            return new String(ch);
        }
    }

    class Solution {
        public String reverseStr(String s, int k) {
            char[] ch = s.toCharArray();
            // 1. 每隔 2k 个字符的前 k 个字符进行反转
            for (int i = 0; i < ch.length; i += 2 * k) {
                // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
                if (i + k <= ch.length) {
                    reverse(ch, i, i + k - 1);
                    continue;
                }
                // 3. 剩余字符少于 k 个，则将剩余字符全部反转
                reverse(ch, i, ch.length - 1);
            }
            return new String(ch);

        }

        // 定义翻转函数
        public void reverse(char[] ch, int i, int j) {
            for (; i < j; i++, j--) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
            }

        }
    }

}
