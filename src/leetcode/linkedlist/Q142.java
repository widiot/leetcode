package leetcode.linkedlist;

import common.ListNode;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Q142 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode l = solution.detectCycle(ListNode.get5());
        System.out.println(l.val);
    }

    public static class Solution {
        public ListNode detectCycle(ListNode head) {
            // 计算环的节点数n，然后让快指针先走n步，再让慢指针和快指针一起走直到相遇则为入口

            ListNode slow = head, fast = head;

            boolean has = false;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    has = true;
                    break;
                }
            }

            if (has) {
                int n = 0;
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                    ++n;
                    if (slow == fast) {
                        break;
                    }
                }

                slow = head;
                fast = head;
                while (n-- != 0) {
                    fast = fast.next;
                }

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }

            return null;
        }
    }

    public static class Solution1 {
        public ListNode detectCycle(ListNode head) {
            // Floyd算法
            // 慢指针初始化为头节点，快指针初始化为第一个相遇的节点，然后两个指针一起走，直到相遇，则为入口节点

            ListNode slow = head, fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    break;
                }
            }

            if (fast != null && fast.next != null) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

            return null;
        }
    }
}
