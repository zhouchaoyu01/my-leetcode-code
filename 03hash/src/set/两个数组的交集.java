package set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 无序 -- 哈希法
 *         排序 + 双指针
 * @author ChanceZhou
 * @create 2022-01-10-21:04
 */
public class 两个数组的交集 {

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{1, 2};

//        int[] res = Solution.intersection(num1, num2);
        int[] res = Solution2.intersection(num1, num2);


        System.out.println(Arrays.toString(res));

    }
}


class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                resultSet.add(i);
            }
        }

        int[] resultArray = new int[resultSet.size()];
        int index = 0;
        for (Integer i : resultSet) {
            resultArray[index++] = i;
        }

        return resultArray;
    }
}

/* cuowu
class Solution2 {
    public static int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length;
        int l2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] res = new int[l1 + l2];

        while (index1 < l1 && index2 < l2) {
            if (nums1[index1] < nums2[index2]) index1++;
            else if (nums1[index1] == nums2[index2]) {
                res[index++] = nums1[index1];
                index1++;
                index2++;
            } else {
                index2++;
            }

        }
        return res;
    }

}
*/

class Solution2 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}

