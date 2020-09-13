package leetcode.linkedlist;

import common.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class Q83 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode l = solution.deleteDuplicates(ListNode.get4());
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 相比Q82，递归用head，保留一个重复的数字

            if (head == null || head.next == null) {
                return head;
            }

            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                return deleteDuplicates(head);
            } else {
                head.next = deleteDuplicates(head.next);
                return head;
            }
        }
    }

    static class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            // 迭代
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
        }
    }
}
