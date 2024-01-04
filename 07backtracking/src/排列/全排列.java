package 排列;

import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChanceZhou
 * @code this file2022-04-24-9:34
 */
public class 全排列 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int nums[] = new int[]{1,2,3};
        List<List<Integer>> permute = s.permute(nums);
        System.out.println(permute);
    }


}
class Solution{

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums){
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, used);
        return res;
    }


    public void permuteHelper(int[] nums, boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i])continue;

            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }
}