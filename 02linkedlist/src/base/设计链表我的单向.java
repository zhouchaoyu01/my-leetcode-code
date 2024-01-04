/**
 * @author ChanceZhou
 * @create 2022-01-14-20:34
 */
public class 设计链表我的单向 {


    class MyLinkedList {
        class ListNode {
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

        //属性
        int size;
        ListNode dummyHead;

        //初始化一个虚拟头结点
        public MyLinkedList() {
            dummyHead = new ListNode(0);
            size = 0;
        }

        //获取第index个节点的数值
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = dummyHead;
            //包含一个虚拟头节点，所以查找第 index+1 个节点
            for (int i = 0; i <= index; i++) {
                // 1 2 3 找第二个元素 即3（index从0 开始）
                // 加入虚拟头结点后 0 1 2 3
                //      i=0 cur->1
                //      i=1 cur->2
                //      i=2 cur->3
                //需要等号
                cur = cur.next;
            }
            return cur.val;
        }

        // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
        // 如果 index 大于链表的长度，则返回空
        public void addAtIndex(int index, int val) {
            if (index < 0) {
                index = 0;
            }
            if (index > size) {
                return;
            }
            ListNode cur = dummyHead;
            //去掉=号，得到第index个元素的前一个元素（这里指的是不包括虚拟结点的 如第0个元素就是1， 而不是虚拟头结点0）
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            ListNode pre = cur;
            ListNode item = new ListNode(val);
            item.next = pre.next;
            pre.next = item;
            //别忘了节点数+1
            size++;


        }

        //删除第index个节点   如果索引 index 有效，则删除链表中的第 index 个节点。
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            size--;
            ListNode pre = dummyHead;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;

        }

        //在链表最前面插入一个节点
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        //在链表的最后插入一个节点
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
