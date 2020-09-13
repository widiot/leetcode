package leetcode.linkedlist;

import common.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Q19 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = ListNode.get1();
        ListNode l2 = solution.removeNthFromEnd(l1, 0);

        while (l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 三指针，考察边界条件，删除头节点和尾节点两种情况
            ListNode pre = null, slow = head, fast = head;

            int i = 1;
            while (i < n && fast.next != null) {
                fast = fast.next;
                ++i;
            }
            if (i != n) {
                return head;
            }

            while (fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next;
            }

            if (pre == null) {
                head = head.next;
            } else {
                pre.next = slow.next;
            }

            return head;
        }
    }

    static class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 双指针，考察边界条件，删除头节点和尾节点两种情况
            // 使用dummy解决边界情况，要让fast走到null节点，这样就不用特殊处理尾节点删除
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode slow = dummy, fast = dummy;
            for (int i = 0; i <= n; ++i) {
                fast = fast.next;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;

            return dummy.next;
        }
    }
}
