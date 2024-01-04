import java.util.Scanner;

/**
 * @author ChanceZhou
 * @code this file2022-05-21-13:39
 */
public class 单调递增的数字 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Solution1 solution = new Solution1();
//        int res = solution.singleIncrementNum(N);
        int res = solution.monotoneIncreasingDigits(N);
        System.out.println(res);
    }

}

/**
 * o(N*m) m为N数字长度
 */
class Solution {
    public int singleIncrementNum(int N) {

        for (int i = N; i >= 0; i--) {
            if (checkNum(i))
                return i;
        }
        return 0;
    }

    private boolean checkNum(int i) {
        int max = 10;
        while (i > 0) {
            int digit = i % 10;
            if (max >= digit) max = digit;
            else return false;
            i /= 10;
        }
        return true;
    }

}


/**
 * 将N转换为字符串
 *
 * i-1 位置如果大于 i 就将i-1位置的数字减1（如果是1呢？） i的位置的数字改为9
 *
 * 从后向前遍历（为什么不从前向后 332）
 *
 * 对于10这样的改为09 String.valueOf解决了这个问题 直接变成9
 */

class Solution1{

    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i+1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

}
