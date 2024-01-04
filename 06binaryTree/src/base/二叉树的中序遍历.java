package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChanceZhou
 * @code this file2022-02-12-20:10
 */
public class 二叉树的中序遍历 {


    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inorder(root, res);
            return res;

        }

        /*更换        list.add(root.val); 的位置便实现其他遍历版本 此为中序遍历*/
        public void inorder(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);

        }
    }

    class Solution2 {
        //lvr
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            //栈
            LinkedList<TreeNode> stack = new LinkedList<>();

            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }
    }
}
