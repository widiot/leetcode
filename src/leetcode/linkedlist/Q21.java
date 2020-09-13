package leetcode.linkedlist;

import common.ListNode;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Q21 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = solution.mergeTwoLists(ListNode.get2(), ListNode.get2());
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 考察归并排序

            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            ListNode head = new ListNode();
            ListNode cur = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            while (l1 != null) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
            while (l2 != null) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }

            return head.next;
        }
    }

    static class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 考察归并排序
            // 最后合并，直接把链表连上就行，不用再对比

            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            ListNode head = new ListNode();
            ListNode cur = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            cur.next = l1 == null ? l2 : l1;

            return head.next;
        }
    }

    static class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // 考察归并排序
            // 递归实现

            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
}
