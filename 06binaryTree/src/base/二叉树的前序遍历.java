package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChanceZhou
 * @code this file2022-02-12-20:10
 */
public class 二叉树的前序遍历 {

    class Solution {
        //vlr
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            //栈
            LinkedList<TreeNode> stack = new LinkedList<>();

            while (root != null || !stack.isEmpty()) {
                while (root!= null) {
                    res.add(root.val);
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            return res;
        }
    }
}
