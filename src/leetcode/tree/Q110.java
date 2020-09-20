package leetcode.tree;

import common.TreeNode;

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class Q110 {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            int left = height(root.left);
            int right = height(root.right);
            return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        public int height(TreeNode root) {
            if (root == null) return 0;
            int left = height(root.left);
            int right = height(root.right);
            return Math.max(left, right) + 1;
        }
    }

    class Solution1 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        public int height(TreeNode root) {
            if (root == null) return 0;
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
