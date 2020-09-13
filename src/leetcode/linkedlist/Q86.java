package leetcode.linkedlist;

import common.ListNode;

/**
 * 86. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 */
public class Q86 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = solution.partition(ListNode.get1(), 7);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            // 把比x小的节点单独摘出来成一个链表，然后跟大于等于x的链表连起来

            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode newHead = null, tail = null;
            ListNode cur = dummy;
            while (cur.next != null) {
                if (cur.next.val < x) {
                    if (tail != null) {
                        tail.next = cur.next;
                        tail = tail.next;
                    } else {
                        newHead = cur.next;
                        tail = newHead;
                    }
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            if (newHead != null) {
                tail.next = dummy.next;
                head = newHead;
            }

            return head;
        }
    }
}