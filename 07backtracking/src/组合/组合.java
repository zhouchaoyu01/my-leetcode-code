package 组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChanceZhou
 * @code this file2022-04-10-16:43
 */
public class 组合 {
    //res 放最后结果
    List<List<Integer>> res = new ArrayList<>();
    //path 放单次的结果
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {

        backtracking(n,k,1);
        return res;
    }

    /**
     * @param n
     * @param k
     * @param startIndex 开始索引，类似树的深度
     */
    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {//path大小等于k个，结束(到达叶子结点)
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {//横向遍历
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }

    }
}
