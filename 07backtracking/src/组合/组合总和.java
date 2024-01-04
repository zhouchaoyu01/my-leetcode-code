package 组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1： 输入：candidates = [2,3,6,7], target = 7, 所求解集为： [ [7], [2,2,3] ]
 * <p>
 * 示例 2： 输入：candidates = [2,3,5], target = 8, 所求解集为： [   [2,2,2,2],   [2,3,3],   [3,5] ]
 *
 * @author ChanceZhou
 * @code this file2022-04-11-20:12
 */
public class 组合总和 {
    class Solution {
        //res 放最后结果
        List<List<Integer>> res = new ArrayList<>();
        //path 放单次的结果
        LinkedList<Integer> path = new LinkedList<>();
        public void backtracking(int[] candidates, int target, int sum, int startIndex) {
            if (sum > target) return;

            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                //剪枝
                if(sum + candidates[i] > target)continue;
                sum += candidates[i];
                path.add(candidates[i]);
                backtracking(candidates, target, sum, i);
                path.removeLast();
                sum -= candidates[i];
            }
        }
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            int sum = 0;
            backtracking(candidates, target, sum, target);
            return res;
        }

    }
}
