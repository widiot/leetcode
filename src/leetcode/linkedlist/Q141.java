package leetcode.linkedlist;

import common.ListNode;

/**
 *
 */
public class Q141 {
    public static void main(String[] args) {

    }

    public static class Solution {
        public boolean hasCycle(ListNode head) {
            // 快慢指针，快指针追上慢指针

            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }

            return false;
        }
    }
}
