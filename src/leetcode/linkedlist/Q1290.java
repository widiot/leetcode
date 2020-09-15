package leetcode.linkedlist;

import common.ListNode;

/**
 * 1290. 二进制链表转整数
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class Q1290 {

    class Solution {
        public int getDecimalValue(ListNode head) {
            int num = 0;
            while (head != null) {
                num <<= 1;
                num |= head.val;
                head = head.next;
            }
            return num;
        }
    }
}
