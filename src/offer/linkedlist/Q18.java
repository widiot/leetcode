package offer.linkedlist;

/**
 * 删除链表的结点
 */
public class Q18 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode head = deleteNode(n1, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head, nxt = head.next, newHead = head;
        while (cur != null) {
            if (cur.val == val) {
                if (pre != null) {
                    pre.next = nxt;
                } else {
                    cur.next = null;
                    newHead = nxt;
                }
                break;
            }
            pre = cur;
            cur = nxt;
            nxt = nxt == null ? null : nxt.next;
        }
        return newHead;
    }
}
