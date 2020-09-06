package offer.linkedlist;

/**
 * 合并两个排序的链表
 */
public class Q25 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        ListNode h = mergeTwoLists(n1, n4);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1, p2 = l2, p3 = null, p4 = null;
        ListNode n1;
        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) {
                n1 = new ListNode(p1.val);
                n1.next = new ListNode(p1.val);
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.val < p2.val) {
                n1 = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                n1 = new ListNode(p2.val);
                p2 = p2.next;
            }
            if (p3 == null) {
                p3 = n1;
                p4 = n1;
            } else {
                p4.next = n1;
                p4 = p4.next;
            }
            while (p4.next != null) {
                p4 = p4.next;
            }
        }
        while (p1 != null) {
            n1 = new ListNode(p1.val);
            p4.next = n1;
            p4 = p4.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            n1 = new ListNode(p2.val);
            p4.next = n1;
            p4 = p4.next;
            p2 = p2.next;
        }
        return p3;
    }
}
