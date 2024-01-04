import java.time.Year;

/**
 * @author ChanceZhou
 * @create 2022-01-12-21:00
 */
public class 螺旋矩阵 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];

            //循环不变量 每次都保持相同的区间格式   左闭右开[,)

            //起始坐标
            int startx = 0;
            int starty = 0;

            int loop = n / 2;//循环圈数   3/2 =1  4/2=2
            int offset = 1;//记录每一圈后要修改的区间长度
            int mid = n / 2;//最中间的位置  n为奇数就一个需要单独考虑
            int i, j;
            int count = 1;

            while (loop > 0) {
                i = startx;
                j = starty;
                //上行 左->右
                for (j = starty; j < starty + n - offset; j++) {
                    res[startx][j] = count++;
                }
                //右行 上->下
                for (; i < startx + n - offset; i++) {
                    res[i][j] = count++;
                }
                //下行 右->左
                for (; j > starty; j--) {
                    res[i][j] = count++;
                }
                //左行 下->上
                for (; i > startx; i--) {
                    res[i][j] = count++;
                }
                startx++;
                starty++;
                offset += 2;

                loop--;
            }
            if (n % 2 != 0) {
                //奇数
                res[mid][mid] = count;
            }
            return res;
        }
    }
}
