package offer.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 从尾到头打印链表
 */
public class Q06 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n1.next = n3;
        n3.next = n2;
        System.out.println(Arrays.toString(reversePrint(n1)));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        fun(head, list);
        return list.stream().mapToInt(v -> v).toArray();
    }

    public static void fun(ListNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            fun(node.next, list);
        }
        list.add(node.val);
    }
}
