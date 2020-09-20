package leetcode.tree;

import common.TreeNode;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Q105 {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
            // 前序找到根节点
            TreeNode root = new TreeNode(preorder[0]);
            // 中序划分左右子树
            int i = 0;
            while (inorder[i] != preorder[0]) ++i;
            root.left = buildTree(i > 0 ? Arrays.copyOfRange(preorder, 1, i + 1) : null, Arrays.copyOfRange(inorder, 0, i));
            root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), i < inorder.length - 1 ? Arrays.copyOfRange(inorder, i + 1, inorder.length) : null);
            return root;
        }
    }

    class Solution1 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
            if (pstart > pend || istart > iend) return null;
            TreeNode root = new TreeNode(preorder[pstart]);
            int i = istart;
            while (i < iend && root.val != inorder[i]) ++i;
            int leftLen = i - istart;
            root.left = buildTree(preorder, pstart + 1, pstart + leftLen, inorder, istart, i - 1);
            root.right = buildTree(preorder, pstart + leftLen + 1, pend, inorder, i + 1, iend);
            return root;
        }
    }
}
