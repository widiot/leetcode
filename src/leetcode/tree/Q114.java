package leetcode.tree;

import common.TreeNode;

/**
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Q114 {
    class Solution {
        public void flatten(TreeNode root) {
            // 因为需要改变根节点的结构，所以根节点需要作为参数
            // 如果左子树不为空，则递归处理左子树
            // 如果左子树为空，则递归处理右子树
            // 处理完左子树后，将左子树连接到根节点的右孩子上，根节点之前的右孩子连接到最右孩子上
            if (root == null) return;
            func(root, root.left, root.right);
        }

        public void func(TreeNode root, TreeNode left, TreeNode right) {
            if (left == null && right == null) return;
            if (left == null) {
                func(right, right.left, right.right);
                return;
            } else {
                func(left, left.left, left.right);
            }
            TreeNode temp = root.right;
            root.left = null;
            root.right = left;
            while (left.right != null) left = left.right;
            left.right = temp;
            func(root.right, root.right.left, root.right.right);
        }
    }

    class Solution1 {
        public void flatten(TreeNode root) {
            // 先将左子树连接到右孩子，再处理右孩子的左子树
            while (root != null) {
                if (root.left == null) {
                    root = root.right;
                } else {
                    TreeNode left = root.left;
                    TreeNode right = root.right;
                    root.left = null;
                    root.right = left;
                    while (left.right != null) left = left.right;
                    left.right = right;
                    root = root.right;
                }
            }
        }
    }

    class Solution2 {
        public void flatten(TreeNode root) {
            // 中序遍历
            if (root == null) return;
            flatten(root.left);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) root = root.right;
            flatten(right);
            root.right = right;
        }
    }
}
