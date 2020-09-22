package leetcode.tree;

import common.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class Q538 {
    class Solution {
        public TreeNode convertBST(TreeNode root) {
            func(root, 0);
            return root;
        }

        public int func(TreeNode root, int val) { // 需要把【根节点+根节点右子树】的值，透传给左孩子的右子树
            // 中序遍历
            if (root == null) return 0;
            int right = func(root.right, val);
            root.val = root.val + right + val;
            int left = func(root.left, root.val);
            return left + root.val - val;
        }
    }
}
