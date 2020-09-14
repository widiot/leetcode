package leetcode.linkedlist;

import common.ListNode;

/**
 * 237. 删除链表中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class Q237 {

    class Solution {
        public void deleteNode(ListNode node) {
            // 改变节点值
            if (node == null || node.next == null) {
                return;
            }
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
