package problems;

import java.util.*;

/**
 * @author ChanceZhou
 * @code this file2022-02-10-18:55
 */
public class 前K个高频元素 {

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            int[] res = new int[k];

            Map<Integer, Integer> resultMap = new HashMap<>();

            /*为什么这种遍历方式不能改变resultMap的值
            for (int i = 0; i < nums.length; i++) {
                if (resultMap.containsKey(nums[i])) {
                    System.out.println(nums[i] + " : " + resultMap.get(nums[i]));
                    int val = resultMap.get(nums[i]);
                    resultMap.put(nums[i], val+1);
                }
                resultMap.put(nums[i], 1);
            }
            */
            for(int num : nums){
                if(resultMap.containsKey(num)){
                    resultMap.put(num, resultMap.get(num) + 1);
                }else{
                    resultMap.put(num, 1);
                }
            }

            System.out.println("****");
            Set<Map.Entry<Integer, Integer>> entrySet = resultMap.entrySet();
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
            for (Map.Entry<Integer, Integer> entry : entrySet) {
                queue.offer(entry);//入队
                if (queue.size() > k) {
                    queue.poll();//出队
                }
            }

            for (int i = k - 1; i >= 0; i--) {
                res[i] = queue.poll().getKey();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        Solution solution = new Solution();
        int[] ints = solution.topKFrequent(nums, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
