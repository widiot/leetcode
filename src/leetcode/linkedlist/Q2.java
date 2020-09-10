package leetcode.linkedlist;

import common.ListNode;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Q2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.get1();
        ListNode l2 = solution.addTwoNumbers(l1, l1);
        while (l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return func(l1, l2, 0);
        }

        public ListNode func(ListNode l1, ListNode l2, int flag) {
            ListNode cur;
            int curFlag, sum;

            if (l1 == null && l2 == null) {
                if (flag != 0) {
                    cur = new ListNode(flag % 10);
                    curFlag = flag / 10;
                } else {
                    return null;
                }
            } else if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + flag;
                cur = new ListNode(sum % 10);
                curFlag = sum / 10;
            } else if (l1 != null) {
                sum = l1.val + flag;
                cur = new ListNode(sum % 10);
                curFlag = sum / 10;
            } else {
                sum = l2.val + flag;
                cur = new ListNode(sum % 10);
                curFlag = sum / 10;
            }

            cur.next = func(l1 == null ? null : l1.next, l2 == null ? null : l2.next, curFlag);

            return cur;
        }
    }
}
