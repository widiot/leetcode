package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class Q230 {
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (--k == 0) return root.val;
                root = root.right;
            }
            return 0;
        }
    }
}
