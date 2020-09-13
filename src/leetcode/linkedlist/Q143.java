package leetcode.linkedlist;

import common.ListNode;
import common.PrintUtil;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class Q143 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = ListNode.get1();
        solution.reorderList(l);
        PrintUtil.printLinkedList(l);
    }

    static class Solution {
        public void reorderList(ListNode head) {
            // 双指针找到倒数第n个节点，然后换位
            if (head == null || head.next == null) {
                return;
            }
            func(head, 1);
        }

        public ListNode func(ListNode head, int idx) {
            ListNode slow = head, fast = head;
            int i;
            for (i = 0; i < idx && fast != null; ++i) {
                fast = fast.next;
            }
            if (i != idx) {
                head.next = null;
                return null;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            ListNode nxt = head.next;
            head.next = slow;
            slow.next = func(nxt, idx + 1);

            return head;
        }
    }
}
