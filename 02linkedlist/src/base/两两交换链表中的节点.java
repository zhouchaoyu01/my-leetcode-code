import java.util.List;

/**
 * @author ChanceZhou
 * @create 2022-01-16-20:41
 */
public class 两两交换链表中的节点 {
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
        public ListNode swapPairs(ListNode head) {
            //设置一个虚拟头结点
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode cur = dummyHead;

            while (cur.next != null && cur.next.next != null) {
                ListNode temp1 = cur.next;//缓存第一个结点
                ListNode temp2 = cur.next.next.next;//缓存第三个结点及其后面结点

                cur.next = cur.next.next;//将第二个结点接在虚拟头结点后面step1
                cur.next.next = temp1;//将第一个结点接在第二个结点后面step2
                cur.next.next.next = temp2;//将第三个结点接在第一个结点后面

                cur = cur.next.next;// cur移动两位，准备下一轮交换
            }
            return dummyHead.next;
        }
    }
}