/**
 * @author ChanceZhou
 * @create 2022-01-18-17:17
 */
public class 链表相交 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int sizeA = 0;
            int sizeB = 0;
            ListNode curA = headA;
            ListNode curB = headB;
            while (curA != null) {
                curA = curA.next;
                sizeA++;
            }
            while (curB != null) {
                curB = curB.next;
                sizeB++;
            }
            curA = headA;
            curB = headB;
            if (sizeA > sizeB) {
                for (int i = 0; i < sizeA - sizeB; i++) {
                    curA = curA.next;
                }
            }
            if (sizeB >= sizeA) {
                for (int i = 0; i < sizeB - sizeA; i++) {
                    curB = curB.next;
                }
            }

            //长度相等后
            while (curA != null) {
                if (curA != curB) {
                    curA = curA.next;
                    curB = curB.next;
                } else {
                    return curA;
                }
            }
            return null;
        }
    }
}
