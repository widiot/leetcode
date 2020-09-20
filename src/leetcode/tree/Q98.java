package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Q98 {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            // 递归
            return func(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean func(TreeNode root, long lower, long upper) {
            if (root == null) {
                return true;
            }
            if (root.val <= lower || root.val >= upper) {
                return false;
            }
            return func(root.left, lower, root.val) && func(root.right, root.val, upper);
        }
    }

    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            // 迭代，中序遍历，当前节点和前置节点比较，如果小于等于则false
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (pre != null && pre.val >= root.val) return false;
                pre = root;
                root = root.right;
            }
            return true;
        }
    }
}
