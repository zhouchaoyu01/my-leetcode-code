/**
 * @author ChanceZhou
 * @create 2022-01-11-20:43
 */
public class 移除元素 {

    class Solution {
        public int removeElement(int[] nums, int val) {
            int slowIndex = 0;
            int fastIndex = 0;
            while (fastIndex < nums.length) {
                if (nums[fastIndex] != val) {
                    nums[slowIndex++] = nums[fastIndex];
                }
                fastIndex++;
            }
            return slowIndex;
        }
    }
}