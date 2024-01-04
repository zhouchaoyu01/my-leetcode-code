/**
 * @author ChanceZhou
 * @create 2022-01-13-20:23
 */
public class 移除链表元素 {
    /**
     * Definition for singly-linked list.
     */
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

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            //虚拟结点
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode cur = dummyHead;

            while (cur.next != null) {
                if (cur.next.val == val) {
                    ListNode tmp = cur.next;
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            head = dummyHead.next;
            return head;
        }
    }
}
