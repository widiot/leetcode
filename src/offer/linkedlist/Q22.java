package offer.linkedlist;

/**
 * 链表中倒数第k个节点
 */
public class Q22 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode node = getKthFromEnd(n1, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        for (int i = 1; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
