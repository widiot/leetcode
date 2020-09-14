package leetcode.linkedlist;

import common.ListNode;
import common.PrintUtil;

/**
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 */
public class Q148 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = solution.sortList(ListNode.get1());
        PrintUtil.printLinkedList(l);
    }

    static class Solution {
        public ListNode sortList(ListNode head) {
            // 归并排序，递归解法，不符合题目要求

            if (head == null || head.next == null) { // 空或单节点已经有序
                return head;
            }

            ListNode slow = head, fast = head.next; // 快慢指针找到中间分割点
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode slowNext = slow.next; // 递归左右两个链表，得到排序后的头节点
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(slowNext);

            ListNode dummy = new ListNode(0); // 归并排序
            ListNode cur = dummy;
            while (left != null && right != null) {
                if (left.val <= right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            }
            cur.next = left == null ? right : left;

            return dummy.next;
        }
    }


    static class Solution1 {
        public ListNode sortList(ListNode head) {
            // 迭代解法，从底向上归并，按1、2、4...进行分组归并

            if (head == null || head.next == null) {
                return head;
            }

            int len = 0; // 链表长度，用于控制分组
            ListNode temp = head;
            while (temp != null) {
                ++len;
                temp = temp.next;
            }

            ListNode dummy = new ListNode(0); // dummy解决头节点插入问题
            dummy.next = head;

            ListNode begin, left, right;
            for (int i = 1; i < len; i *= 2) { // 按1、2、4...进行分组，直到整个链表为一组
                begin = dummy;
                for (int j = 0; (j + i) < len; j = (2 * i + j)) { // 分组第一个节点的索引，j+i>=n表示已经超过分组，最后一个分组数量少
                    left = begin.next;
                    right = left;

                    for (int k = 0; k < i && right != null; ++k) { // right移动到第二个分组头，可能没有第二个分组
                        right = right.next;
                    }

                    int m = 0, n = 0;
                    while (m < i && n < i && right != null) { // 开始归并
                        if (left.val <= right.val) {
                            begin.next = left;
                            begin = begin.next;
                            left = left.next;
                            ++m;
                        } else {
                            begin.next = right;
                            begin = begin.next;
                            right = right.next;
                            ++n;
                        }
                    }
                    while (m < i) {
                        begin.next = left;
                        begin = begin.next;
                        left = left.next;
                        ++m;
                    }
                    while (n < i && right != null) {
                        begin.next = right;
                        begin = begin.next;
                        right = right.next;
                        ++n;
                    }

                    begin.next = right;
                }
            }

            return dummy.next;
        }
    }
}
