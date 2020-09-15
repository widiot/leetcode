package leetcode.linkedlist;

import common.ListNode;
import common.TreeNode;

/**
 * 1367. 二叉树中的列表
 * https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 */
public class Q1367 {

    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            if (root == null) {
                return false;
            }
            if (root.val == head.val && func(root, head)) {
                return true;
            } else {
                return isSubPath(head, root.left) || isSubPath(head, root.right);
            }
        }

        public boolean func(TreeNode root, ListNode head) {
            if (head == null) {
                return true;
            }
            if (root == null) {
                return false;
            }
            if (root.val != head.val) {
                return false;
            }
            return func(root.left, head.next) || func(root.right, head.next);
        }
    }
}
