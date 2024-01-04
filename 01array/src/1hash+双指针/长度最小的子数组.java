/**
 * @author ChanceZhou
 * @create 2022-01-11-21:38
 */
public class 长度最小的子数组 {
    class Solution {

        // 滑动窗口
        public int minSubArrayLen(int s, int[] nums) {
            int left = 0;// 滑动窗口起始位置
            int sum = 0;// 滑动窗口数值之和
            int result = Integer.MAX_VALUE;
            int subLength = 0; // 滑动窗口的长度
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                // 注意这里使用while，每次更新 left（起始位置），并不断比较子序列是否符合条件
                while (sum >= s) {
                    subLength = right - left + 1;
                    result = Math.min(result, subLength);
                    sum -= nums[left++];// 这里体现出滑动窗口的精髓之处，不断变更left（子序列的起始位置）
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }
}
