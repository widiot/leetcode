package leetcode.linkedlist;

import common.ListNode;
import common.PrintUtil;

/**
 * 445. 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class Q445 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = solution.addTwoNumbers(ListNode.get7(), ListNode.get8()); // 144
        PrintUtil.printLinkedList(l);
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 递归，从尾节点开始相加，前面高位不齐的，用0补齐，多出来的进位需要单独再插入节点

            if (l1 == null) return l2;
            if (l2 == null) return l1;

            int len1 = 0, len2 = 0;
            for (ListNode i = l1; i != null; i = i.next) {
                ++len1;
            }
            for (ListNode i = l2; i != null; i = i.next) {
                ++len2;
            }

            ListNode dummy = new ListNode(0);
            int carry = func(l1, l2, len1 - len2, dummy);

            while (carry != 0) {
                ListNode node = new ListNode(carry % 10);
                node.next = dummy.next;
                dummy.next = node;
                carry /= 10;
            }

            return dummy.next;
        }

        public int func(ListNode l1, ListNode l2, int fill, ListNode head) {
            if (l1 == null || l2 == null) {
                return 0;
            }

            int carry;
            ListNode cur1, cur2;
            if (fill > 0) {
                cur1 = l1;
                cur2 = new ListNode(0);
                carry = func(l1.next, l2, fill - 1, head);
            } else if (fill < 0) {
                cur1 = new ListNode(0);
                cur2 = l2;
                carry = func(l1, l2.next, fill + 1, head);
            } else {
                cur1 = l1;
                cur2 = l2;
                carry = func(l1.next, l2.next, fill, head);
            }

            int sum = cur1.val + cur2.val + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;

            return sum / 10;
        }
    }
}