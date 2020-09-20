package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Q104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    class Solution1 {
        public int maxDepth(TreeNode root) {
            //层序遍历
            if (root == null) return 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    root = queue.poll();
                    if (root.left != null) queue.offer(root.left);
                    if (root.right != null) queue.offer(root.right);
                }
                ++depth;
            }
            return depth;
        }
    }
}
