package other;


import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author ChanceZhou
 * @code this file2022-03-11-22:05
 */
public class 对称二叉树 {


    /*
     * 递归
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return compareLR(root.left, root.right);
        }

        public boolean compareLR(TreeNode left, TreeNode right) {
            //左右节点不存在
            if (left == null && right == null) return true;
                //右节点不存在
            else if (left != null && right == null) return false;
                //左节点不存在
            else if (left == null && right != null) return false;
                //左右节点存在，但数值不等
            else if (left.val != right.val) return false;


            //此时做判断
            boolean outside = compareLR(left.left, right.right);
            boolean inside = compareLR(left.right, right.left);
            boolean isSame = outside && inside;

            return isSame;
        }
    }

    /*
     * 队列和栈一致，将LinkedList换成Stack也行
     */
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;


            LinkedList<TreeNode> deque = new LinkedList<>();

            deque.push(root.left);
            deque.push(root.right);

            while (!deque.isEmpty()) {
                TreeNode leftNode = deque.peek();
                deque.pop();
                TreeNode rightNode = deque.peek();
                deque.pop();


                if (leftNode == null && rightNode == null) continue;
                if (leftNode == null || rightNode == null || (leftNode.val != rightNode.val)) {
                    return false;
                }
                deque.push(leftNode.left);
                deque.push(rightNode.right);
                deque.push(leftNode.right);
                deque.push(rightNode.left);

            }
            return true;

        }
    }


}

