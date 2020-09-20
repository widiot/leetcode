package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class Q101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            // 递归
            return func(root, root);
        }

        public boolean func(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null ^ q == null) return false;
            return p.val == q.val && func(p.left, q.right) && func(p.right, q.left);
        }
    }

    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            // 迭代
            return func(root, root);
        }

        public boolean func(TreeNode p, TreeNode q) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(p);
            queue.offer(q);
            while (!queue.isEmpty()) {
                p = queue.poll();
                q = queue.poll();
                if (p == null && q == null) continue;
                if (p == null ^ q == null) return false;
                if (p.val != q.val) return false;
                queue.offer(p.left);
                queue.offer(q.right);
                queue.offer(p.right);
                queue.offer(q.left);
            }
            return true;
        }
    }
}
