package leetcode.linkedlist;

import common.ListNode;
import common.PrintUtil;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class Q109 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        TreeNode root = solution.sortedListToBST(ListNode.get2());
        PrintUtil.printBinaryTree(root);
    }

    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            // 中序遍历的逆过程

            if (head == null) {
                return null;
            }

            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }

            return func(list, 0, list.size() - 1);
        }

        public TreeNode func(List<ListNode> list, int start, int end) {
            if (start > end) {
                return null;
            }

            int mid = (start + end + 1) / 2;

            TreeNode root = new TreeNode(list.get(mid).val);
            root.left = func(list, start, mid - 1);
            root.right = func(list, mid + 1, end);

            return root;
        }
    }

    static class Solution1 {
        public TreeNode sortedListToBST(ListNode head) {
            // 不用额外空间解法，快慢指针找中间节点
            return func(head, null);
        }

        public TreeNode func(ListNode head, ListNode tail) {
            if (head == tail) {
                return null;
            }

            ListNode slow = head, fast = head;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }

            TreeNode root = new TreeNode(slow.val);
            root.left = func(head, slow);
            root.right = func(slow.next, tail);

            return root;
        }
    }
}
