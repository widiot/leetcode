package leetcode.tree;

import common.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Q235 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) return root;
            return left == null ? right : left;
        }
    }

    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q); // p,q都在右子树
            else if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q); // p,q都在左子树
            else return root; // p,q在左右子树，所以当前节点即为公共祖先
        }
    }

    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (root != null) {
                if (p.val < root.val && q.val < root.val) root = root.left;
                else if (p.val > root.val && q.val > root.val) root = root.right;
                else return root;
            }
            return null;
        }
    }
}
