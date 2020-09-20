package leetcode.tree;

import common.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */
public class Q222 {
    class Solution {
        public int countNodes(TreeNode root) {
            return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
        }
    }

    class Solution1 {
        public int countNodes(TreeNode root) {
            // 二分法
            if (root == null) return 0;
            int depth = 0;
            TreeNode cur = root;
            while (cur.left != null) {
                ++depth;
                cur = cur.left;
            }
            if (depth == 0) return 1;
            int left = 0, right = (int) Math.pow(2, depth) - 1; // 最后一层的索引
            while (left <= right) {
                int mid = (left + right) / 2;
                if (exists(mid, depth, root)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return (int) Math.pow(2, depth) - 1 + left;
        }

        public boolean exists(int idx, int d, TreeNode node) {
            int left = 0, right = (int) Math.pow(2, d) - 1;
            for (int i = 0; i < d; ++i) {
                int mid = (left + right) / 2;
                if (idx <= mid) {
                    node = node.left;
                    right = mid;
                } else {
                    node = node.right;
                    left = mid + 1;
                }
            }
            return node != null;
        }
    }
}
