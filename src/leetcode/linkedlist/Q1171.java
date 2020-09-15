package leetcode.linkedlist;

import common.ListNode;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 */
public class Q1171 {

    class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode pre = dummy, left = head, right = head;
            int sum;
            while (left != null) {
                sum = 0;
                while (right != null) {
                    sum += right.val;
                    if (sum == 0) {
                        pre.next = right.next;
                        break;
                    }
                    right = right.next;
                }
                if (right == null) {
                    pre = left;
                    right = left = left.next;
                } else {
                    right = left = pre.next;
                }
            }

            return dummy.next;
        }
    }
}
