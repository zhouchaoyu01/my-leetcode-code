import java.util.List;

/**
 * @author ChanceZhou
 * @create 2022-01-16-19:35
 */

public class 反转链表 {

    class Solution {

        //Definition for singly-linked list.
        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        public ListNode reverseList(ListNode head) {
            ListNode temp;//保存下一个结点
            ListNode cur = head;
            ListNode reversedHead = null;
            while (cur != null) {
                temp = cur.next;
                cur.next = reversedHead;
                reversedHead = cur;
                cur = temp;
            }
            return reversedHead;
        }
    }
}
