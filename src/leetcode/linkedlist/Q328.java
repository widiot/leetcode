package leetcode.linkedlist;

import common.ListNode;
import common.PrintUtil;

/**
 * 328. 奇偶链表
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class Q328 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = solution.oddEvenList(ListNode.get7());
        PrintUtil.printLinkedList(l);
    }

    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode oddHead = head, evenHead = head.next;
            ListNode oddTail = oddHead, evenTail = evenHead;
            ListNode cur = head.next.next;
            oddTail.next = null;
            evenTail.next = null;
            while (cur != null && cur.next != null) {
                oddTail.next = cur;
                oddTail = oddTail.next;
                evenTail.next = cur.next;
                evenTail = evenTail.next;
                cur = cur.next.next;
                oddTail.next = null;
                evenTail.next = null;
            }

            if (cur != null) {
                oddTail.next = cur;
                oddTail = oddTail.next;
            }

            oddTail.next = evenHead;

            return oddHead;
        }
    }

    static class Solution1 {
        public ListNode oddEvenList(ListNode head) {
            // 官方解法，简洁
            if (head == null) {
                return head;
            }
            ListNode odd = head, even = head.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }
}
