package zfc;

/**
 * @author ChanceZhou
 * @code this file2022-01-23-15:53
 */
public class 反转字符串 {

    class Solution {
        public void reverseString(char[] s) {

            //left代表左端  right代表右端
            int left = 0;
            int right = s.length - 1;
            char temp;
            while (right > left) {
                temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
    }
}
