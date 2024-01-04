package zfc;

import java.util.Arrays;

/**
 * @author ChanceZhou
 * @code this file2022-07-05-15:29
 */
public class 比较含退格的字符串 {

    /**
     * 存在error
     */
    static class Solution {
        public boolean backspaceCompare(String s, String t) {


            if(s.length() == 1 && t.length() == 1)return s.equals(t);
            System.out.println(deleteBack(s));
            return deleteBack(s).equals(deleteBack(t));



        }


        public String deleteBack(String s){
        /*
        快指针遇到# 慢指针后退一步；否则将快指针的值赋给慢指针数组
         */
            char[] str = s.toCharArray();
            int slow = 0;
            for(int fast = 1;fast < str.length;fast++){
                if(str[fast] != '#')str[++slow] = str[fast];
                else{
                    slow-=1;
                }
            }


            return new String(Arrays.copyOfRange(str, 0, slow+1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ab#c";
        String t = "ad#c";
        boolean b = solution.backspaceCompare(s, t);
        System.out.println(b);

    }
}


class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}

作者：LeetCode-Solution
        链接：https://leetcode.cn/problems/backspace-string-compare/solution/bi-jiao-han-tui-ge-de-zi-fu-chuan-by-leetcode-solu/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
