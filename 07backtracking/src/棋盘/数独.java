package 棋盘;

/**
 * @author ChanceZhou
 * @code this file2022-04-30-20:14
 */
public class 数独 {
    class Solution {
        public void solveSudoku(char[][] board) {
            solveSudokuHelper(board);
        }

        private boolean solveSudokuHelper(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    if (board[i][j] != '.') { // 跳过原始数字
                        continue;
                    }

                    for (char k = '1'; k <= '9'; k++) {
                        if (isVaild(i, j, k, board)) {
                            board[i][j] = k;
                            if (solveSudokuHelper(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }

            }

            return true;
        }

        private boolean isVaild(int row, int col, char val, char[][] board) {
            //检查行
            for (int i = 0; i < col; i++) {
                if (board[row][i] == val) {
                    return false;
                }
            }
            //检查列
            for (int j = 0; j < col; j++) {
                if (board[j][col] == val) {
                    return false;
                }
            }
            //检查大格子里面
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] == val) return false;

                }
            }


            //以上都通过则检查合格
            return true;
        }
    }
}
