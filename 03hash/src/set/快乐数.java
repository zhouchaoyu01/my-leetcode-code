package set;

import java.util.HashSet;

/**
 * @author ChanceZhou
 * @create 2022-01-21-19:05
 */
public class 快乐数 {

    static class Solution {
        public int getSum(int n) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            return sum;
        }

        public boolean isHappy(int n) {
            HashSet<Integer> s = new HashSet<>();
            while (true) {
                int sum = getSum(n);
                if (sum == 1) {
                    return true;
                }

                if (s.contains(sum)) {
                    break;
                }
                s.add(sum);
                n = sum;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 19;
        Solution solution = new Solution();
        boolean isTrue = solution.isHappy(n);
        System.out.println(isTrue);
    }
}
