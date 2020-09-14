package leetcode.linkedlist;

import common.ListNode;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Q206 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null, cur = head, nxt;
            while (cur != null) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            return pre;
        }
    }

    class Solution1 {
        public ListNode reverseList(ListNode head) {
            // 递归到尾节点，依次向前反转，返回新的头节点
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return pre;
        }
    }
}
