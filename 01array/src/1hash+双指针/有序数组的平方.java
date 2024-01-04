/**
 * @author ChanceZhou
 * @create 2022-01-11-21:15
 */
public class 有序数组的平方 {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];
            int low = 0;
            int high = nums.length - 1;
            int index = high;
            while (index >= 0) {
                if (nums[low] * nums[low] >= nums[high] * nums[high]) {
                    res[index--] = nums[low] * nums[low];
                    low++;
                } else {
                    res[index--] = nums[high] * nums[high];
                    high--;
                }
            }

            return res;
        }
    }
}
