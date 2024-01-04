package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChanceZhou
 * @create 2022-01-21-20:43
 */
public class 四数相加 {
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> ab = new HashMap<>();
            int sumab;
            int rs = 0;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    sumab = nums1[i] + nums2[j];
                    if (ab.containsKey(sumab)) {
                        ab.put(sumab, ab.get(sumab) + 1);
                    } else {
                        ab.put(sumab, 1);
                    }

                }
            }

            for (int i : nums3) {
                for (int j : nums4) {
                    int sumcd = i + j;
                    if (ab.containsKey(0 - sumcd)) {
                        rs += ab.get(0 - sumcd);
                    }
                }
            }
            return rs;
        }
    }
}
