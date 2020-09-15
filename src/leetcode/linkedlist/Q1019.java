package leetcode.linkedlist;

import common.ListNode;

import java.util.ArrayList;

/**
 * 1019. 链表中的下一个更大节点
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 */
public class Q1019 {

    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            // 双指针
            if (head == null) {
                return new int[0];
            }
            ArrayList<Integer> list = new ArrayList<>();
            ListNode left = head, right = head.next;
            while (left != null) {
                while (right != null) {
                    if (right.val > left.val) {
                        list.add(right.val);
                        break;
                    }
                    right = right.next;
                }
                if (right == null) {
                    list.add(0);
                }
                left = left.next;
                right = left == null ? null : left.next;
            }
            return list.stream().mapToInt(x -> x).toArray();
        }
    }
}
