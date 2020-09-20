package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class Q226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }

    class Solution1 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode head = root;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                root = queue.pop();
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            return head;
        }
    }
}
