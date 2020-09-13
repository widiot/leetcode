package leetcode.linkedlist;

import common.ListNode;
import common.PrintUtil;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class Q92 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = solution.reverseBetween(ListNode.get2(), 2, 3);
        PrintUtil.printLinkedList(l);
    }

    static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            // 四指针，指向切口的四个位置，然后反转中间的链表，再连接切口
            if (m == n) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode left1 = dummy, left2 = head, right1 = dummy, right2 = head;
            for (int i = 1; i <= n; ++i) {
                if (i < m) {
                    left1 = left1.next;
                    left2 = left2.next;
                }
                right1 = right1.next;
                right2 = right2.next;
            }

            right1.next = null;
            ListNode pre = null, cur = left2, nxt = left2.next;
            while (cur != null) {
                cur.next = pre;
                pre = cur;
                cur = nxt;
                nxt = nxt == null ? null : nxt.next;
            }

            left1.next = right1;
            left2.next = right2;

            return dummy.next;
        }
    }
}
