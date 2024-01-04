import java.util.Arrays;

/**
 * @author ChanceZhou
 * @code this file2022-04-16-15:20
 */
public class 最长重复子数组 {


    public int findLength1(int[] nums1, int[] nums2) {

        int res = 0;
        //dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。
        int [][] dp = new int[nums1.length+1][nums2.length+1];
        //dp[0][j]  dp[i][0]没有意义  但为了计算方便，全赋为0  （其实也没必要）
        for(int i = 1; i <= nums1.length;i++){
            for(int j = 1; j <= nums2.length;j++){
                if(nums1[i-1] == nums2[j-1])dp[i][j] = dp[i-1][j-1] + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        printArray(dp);

        return res;

    }

    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int result = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                result = Math.max(result, dp[j]);
            }
            System.out.println(Arrays.toString(dp));

        }
        return result;
    }

    public void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }


    /*滑动窗口*/
    public int findLength2(int[] A, int[] B) {
        if (A.length < B.length)
            return findLengthHelper(A, B);
        return findLengthHelper(B, A);
    }

    public int findLengthHelper(int[] A, int[] B) {
        int aLength = A.length, bLength = B.length;
        //total是总共运行的次数
        int total = aLength + bLength - 1;
        int max = 0;
        for (int i = 0; i < total; i++) {
            //下面一大坨主要判断数组A和数组B比较的起始位置和比较的长度
            int aStart = 0;
            int bStart = 0;
            int len = 0;
            if (i < aLength) {
                aStart = aLength - i - 1;
                bStart = 0;
                len = i + 1;
            } else {
                aStart = 0;
                bStart = i - aLength + 1;
                len = Math.min(bLength - bStart, aLength);
            }
            int maxlen = maxLength(A, B, aStart, bStart, len);
            max = Math.max(max, maxlen);
        }
        return max;
    }

    //计算A和B在上面图中红色框内的最大长度
    public int maxLength(int[] A, int[] B, int aStart, int bStart, int len) {
        int max = 0, count = 0;
        for (int i = 0; i < len; i++) {
            if (A[aStart + i] == B[bStart + i]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    /**/

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{3,2,1,4,7};


        最长重复子数组 i = new 最长重复子数组();
        int length = i.findLength(nums1, nums2);
        int length1 = i.findLength1(nums1, nums2);

    }
}
