package leetcode.linkedlist;

import common.ListNode;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Q24 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode l = solution.swapPairs(ListNode.get1());
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            // 三指针，考虑边界条件，头节点交换，和尾节点无法交换

            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = null, left = head, right = head.next;
            while (right != null) {
                left.next = right.next;
                right.next = left;
                if (pre != null) {
                    pre.next = right;
                } else {
                    head = right;
                }
                pre = left;
                left = left.next;
                right = left == null ? null : left.next;
            }

            return head;
        }
    }

    static class Solution1 {
        public ListNode swapPairs(ListNode head) {
            // 递归实现
            if (head == null || head.next == null) {
                return head;
            }

            ListNode right = head.next, next = right.next;

            right.next = head;
            head.next = swapPairs(next);

            return right;
        }
    }
}
