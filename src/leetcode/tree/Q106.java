package leetcode.tree;

import common.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Q106 {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        public TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
            if (istart > iend || pstart > pend) return null;
            TreeNode root = new TreeNode(postorder[pend]);
            int i = istart;
            while (root.val != inorder[i]) ++i;
            int leftLen = i - istart;
            root.left = buildTree(inorder, istart, i - 1, postorder, pstart, pstart + leftLen - 1);
            root.right = buildTree(inorder, i + 1, iend, postorder, pstart + leftLen, pend - 1);
            return root;
        }
    }
}
