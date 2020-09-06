package offer.linkedlist;

/**
 * 两个链表的第一个公共节点
 */
public class Q52 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode h1 = new ListNode(1);
        ListNode h8 = new ListNode(8);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);

        ListNode headB = new ListNode(5);
        ListNode hh0 = new ListNode(0);
        ListNode hh1 = new ListNode(1);

        headA.next = h1;
        h1.next = h8;
        h8.next = h4;
        h4.next = h5;

        headB.next = hh0;
        hh0.next = hh1;
        hh1.next = h8;

        System.out.println(getIntersectionNode(headA, headB).val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int alen = 0;
        int blen = 0;
        ListNode cur = headA;
        while (cur != null) {
            ++alen;
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            ++blen;
            cur = cur.next;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        int diff = Math.abs(alen - blen);
        if (alen > blen) {
            while (diff-- != 0) {
                pa = pa.next;
            }
        } else if (alen < blen) {
            while (diff-- != 0) {
                pb = pb.next;
            }
        }
        while (pa != null) {
            if (pa == pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }
}
