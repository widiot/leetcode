package leetcode.linkedlist;

import common.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Q82 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = solution.deleteDuplicates(ListNode.get3());
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 三指针

            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode pre = dummy, cur = head;
            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) {
                    ListNode nxt = cur.next.next;
                    while (nxt != null && cur.val == nxt.val) {
                        nxt = nxt.next;
                    }
                    pre.next = nxt;
                    cur = pre.next;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }

            return dummy.next;
        }
    }

    static class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            // 递归

            if (head == null || head.next == null) {
                return head;
            }

            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                return deleteDuplicates(head.next);
            } else {
                head.next = deleteDuplicates(head.next);
                return head;
            }
        }
    }
}
