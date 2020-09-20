package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 */
public class Q112 {
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            // 递归
            return func(root, sum, 0);
        }

        public boolean func(TreeNode root, int sum, int cur) {
            if (root == null) return false;
            cur += root.val;
            if (root.left == null && root.right == null) {
                return cur == sum;
            }
            return func(root.left, sum, cur) || func(root.right, sum, cur);
        }
    }

    class Solution1 {
        public boolean hasPathSum(TreeNode root, int sum) {
            // BFS
            if (root == null) return false;
            LinkedList<TreeNode> queue1 = new LinkedList<>();
            LinkedList<Integer> queue2 = new LinkedList<>();
            queue1.offer(root);
            queue2.offer(root.val);
            while (!queue1.isEmpty()) {
                root = queue1.poll();
                int curSum = queue2.poll();
                if (root.left == null && root.right == null) {
                    if (curSum == sum) return true;
                    continue;
                }
                if (root.left != null) {
                    queue1.offer(root.left);
                    queue2.offer(root.left.val + curSum);
                }
                if (root.right != null) {
                    queue1.offer(root.right);
                    queue2.offer(root.right.val + curSum);
                }
            }
            return false;
        }
    }
}
