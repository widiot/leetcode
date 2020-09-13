package leetcode.linkedlist;

import common.ListNode;

/**
 * 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class Q61 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = solution.rotateRight(ListNode.get1(), 2);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            // 连接成循环链表，定位到新的head和tail
            if (head == null || head.next == null || k == 0) {
                return head;
            }

            int len = 1;
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
                ++len;
            }

            k = k % len;
            if (k == 0) {
                return head;
            }

            tail.next = head;
            for (int i = 0; i < (len - k); ++i) {
                head = head.next;
                tail = tail.next;
            }

            tail.next = null;

            return head;
        }
    }

    static class Solution1 {
        public ListNode rotateRight(ListNode head, int k) {
            // 三指针
            if (head == null || head.next == null || k == 0) {
                return head;
            }

            int len = 1;
            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
                ++len;
            }

            k = k % len;
            if (k == 0) {
                return head;
            }

            ListNode pre = null, mid = head;
            for (int i = 0; i < (len - k); ++i) {
                pre = mid;
                mid = mid.next;
            }

            pre.next = null;
            tail.next = head;

            return mid;
        }
    }
}
