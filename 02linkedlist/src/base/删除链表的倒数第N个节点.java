import java.util.List;

/**
 * @author ChanceZhou
 * @create 2022-01-16-21:20
 */
public class 删除链表的倒数第N个节点 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;


            ListNode fast = dummyHead;
            ListNode slow = dummyHead;
            //fast走n+1步，方便找到要删除元素的前一个结点来进行删除操作
            for (int i = 0; i < n + 1; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            //删除slow.next这个元素
            slow.next = slow.next.next;
            return dummyHead.next;
        }
    }
}
