import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChanceZhou
 * @code this file2022-01-22-20:22
 */
public class 四数之和 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                //我错了
                // 这种剪枝是错误的，这道题目target 是任意值
//                int s = nums[i];
//                if(s > target){
//                    return result;
//                }

                if (i > 0 && nums[i] == nums[i - 1]) continue;

                for (int j = i + 1; j < nums.length; j++) {
                    int sum = nums[i] + nums[j];
                    // 这种剪枝是错误的，这道题目target 是任意值
//                    if (sum > target) {
//                        return result;
//                    }

                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (right > left) {
                        if (nums[left] + nums[right] + sum > target) {
                            right--;
                        } else if (nums[left] + nums[right] + sum < target) {
                            left++;
                        } else {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (right > left && nums[left] == nums[left + 1]) left++;
                            while (right > left && nums[right] == nums[right - 1]) right--;

                            left++;
                            right--;
                        }
                    }
                }

            }

            return result;
        }
    }
}
