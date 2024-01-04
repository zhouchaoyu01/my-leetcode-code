import java.util.List;

/**
 * @author ChanceZhou
 * @create 2022-01-18-19:21
 */
public class 环形链表II {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            //该条件限制元素个数至少2个及以上
            while (fast != null && fast.next != null) {
                //fast移动2个每次  slow1个
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    //如果俩者相遇(有环),记录相遇位置为index1,链表的起始位置为index2，index1 = index2
                    ListNode index1 = fast;
                    ListNode index2 = head;
                    while (index2 != index1) {
                        index2 = index2.next;
                        index1 = index1.next;
                    }
                    return index1;//相遇后即为入口
                }
            }
            return null;
        }
    }
}
