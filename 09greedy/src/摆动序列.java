/**
 * @author ChanceZhou
 * @code this file2022-05-05-20:19
 */
public class 摆动序列 {
    class Solution {

        public int wiggleMaxLength(int[] nums) {
            if (nums.length <= 1) return nums.length;

            int preDiff = 0;//上一个差值
            int curDiff = 0;//当前差值
            int count = 1;//计数  记录峰值个数，序列默认序列最右边有一个峰值

            for (int i = 0; i < nums.length - 1; i++) {
                curDiff = nums[i + 1] - nums[i];
                if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                    count++;
                    preDiff = curDiff;
                }

            }
            return count;
        }

    }
}
