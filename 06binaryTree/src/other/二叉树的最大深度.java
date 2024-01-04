package other;

/**
 * @author ChanceZhou
 * @code this file2022-03-12-20:48
 */
public class 二叉树的最大深度 {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            int maxDepth = Math.max(leftDepth, rightDepth) + 1;
            return maxDepth;
        }
    }

    class Solution2 {
        //前序遍历 深度回溯
        public int maxDepth(TreeNode root) {
            res = 0;
            if (root == null) return 0;
            getDepth(root, 1);
            return res;
        }

        int res;

        public void getDepth(TreeNode node, int depth) {
            res = depth > res ? depth : res; //中

            if (node.left == null && node.right == null) return;
            if (node.left != null) {//左
                depth++;//深度加一
                getDepth(node.left, depth);
                depth--;//回溯 深度减一
            }
            if (node.right != null) {//右
                depth++;
                getDepth(node.right, depth);
                depth--;
            }
            return;

        }
    }
}
