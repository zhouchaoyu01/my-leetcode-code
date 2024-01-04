/**
 * @author ChanceZhou
 * @code this file2022-05-02-21:41
 */
public class 回文子串 {

    public int countSubstrings(String s) {
        //存放结果
        int res = 0;
        //1 确定dp[i][j]含义 boolean数组 1代表区间[i,j]为一个回文串
        //2 递推公式  相等情况下
        //单个字符 a i==j  俩个 aa j-i == 1    j-i<2 ||   超过2个 根据子区间[i+1, j -1]来判断（即去掉头尾）
        //3 初始化 全部为false dp[][]
        boolean[][] dp = new boolean[s.length()][s.length()];
        //4 遍历方式 [i+1, j -1] 在[i,j]的左下方 所以要从下往上 从左往右遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {

                    if (j - i < 2) {
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        //5 模拟一下


        return res;
    }

    public int countSubstrings1(String s) {
        int res=0;
        //中心扩散法
        for (int i = 0; i < s.length(); i++) {
            res += extendCenter(s, i, i);
            res += extendCenter(s, i, i+1);
        }
        return res;
    }

    public int extendCenter(String s, int i, int j) {
        int res = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            //向外扩散
            i--;
            j++;
            res++;
        }
        return res;
    }
}
