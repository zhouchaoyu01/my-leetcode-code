import java.util.List;

/**
 * @author ChanceZhou
 * @create 2022-01-15-19:45
 */
public class 设计链表我的双向 {


    class MyLinkedList {


        class ListNode {
            //双向链表
            int val;
            ListNode pre;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next, ListNode pre) {
                this.val = val;
                this.next = next;
                this.pre = pre;
            }
        }

        int size;
        ListNode head, tail;


        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.pre = head;

        }

        public int get(int index) {
            if (index >= size || index < 0) {
                return -1;
            }

            ListNode cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }


        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            ListNode preNode = head;
            //得到要被插入的结点的前一个结点
            for (int i = 0; i < index; i++) {
                preNode = preNode.next;
            }

            ListNode beAddedTo = new ListNode(val);

            beAddedTo.next = preNode.next;
            preNode.next.pre = beAddedTo;
            beAddedTo.pre = preNode;
            preNode.next = beAddedTo;

            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode preNode = head;
            //得到要被插入的结点的前一个结点
            for (int i = 0; i < index; i++) {
                preNode = preNode.next;
            }
            preNode.next = preNode.next.next;
            preNode.next.next.pre = preNode;
            size--;

        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }
    }

}
