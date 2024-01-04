package 组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChanceZhou
 * @code this file2022-04-19-15:54
 */
public class 组合总和2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[]{10,1,2,7,6,1,5 ,8};
        int target = 8;
        List<List<Integer>> lists = solution.combinationSum2(candidates, target);
        System.out.println(lists.toString());
    }


}


class Solution {


    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, int index) {

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > index && candidates[i - 1] == candidates[i]) continue;

            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, index + 1);
            sum -= candidates[i];
            path.removeLast();
        }
    }

}