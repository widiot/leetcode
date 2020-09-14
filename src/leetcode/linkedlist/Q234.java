package leetcode.linkedlist;

import common.ListNode;

/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class Q234 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(ListNode.get6()));
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            // 拆成两半，反转右边，迭代比较
            // 反转右边是因为奇数总数时，左边会多一个，反转左边会出问题

            if (head == null || head.next == null) {
                return true;
            }

            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode rightHead = slow.next;
            slow.next = null;

            ListNode pre = null, cur = rightHead, nxt;
            while (cur != null) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }

            while (pre != null && head != null) {
                if (pre.val != head.val) {
                    return false;
                }
                pre = pre.next;
                head = head.next;
            }

            return true;
        }
    }
}
