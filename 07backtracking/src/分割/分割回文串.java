package 分割;

import java.util.*;

/**
 * @author ChanceZhou
 * @code this file2022-04-20-20:47
 */
public class 分割回文串 {

    /*
    1.抽象为组合问题
    2.分割线在哪里切
    3.判断回文串
    4.递归如何终止
    5.递归如何截取字符串
     */


    public static void main(String[] args) {
        String s = "abbbcbb";
        Solution solution = new Solution();
        List<List<String>> partition = solution.partition(s);
        System.out.println(partition.toString());

    }
}

class Solution {
    List<List<String>> lists = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return lists;
    }


    /**
     * 递归
     * @param s 字符串
     * @param lineIndex 分割线的起始位置
     */
    public void backtracking(String s,int lineIndex){

        if(lineIndex >= s.length()){
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = lineIndex; i < s.length(); i++) {
            if(isPalindrome(s, lineIndex, i)){
                String substring = s.substring(lineIndex, i+1);
                deque.addLast(substring);
            }else{
                continue;
            }
            backtracking(s, i+1);
            deque.removeLast();

        }

    }

    /**
     * 判断是否是回文
     * @param s
     * @param startIndex
     * @param end
     * @return
     */
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end ; i < j; i++,j--) {
            if(s.charAt(i) != s.charAt(j))return false;
        }
        return true;
    }



}

