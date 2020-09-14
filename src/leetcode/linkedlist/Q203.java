package leetcode.linkedlist;

import common.ListNode;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Q203 {

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur != null && cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}
