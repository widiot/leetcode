package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
public class Q100 {

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // 递归
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    class Solution1 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null ^ q == null) return false;
            // 迭代
            LinkedList<TreeNode> pStack = new LinkedList<>();
            LinkedList<TreeNode> qStack = new LinkedList<>();
            pStack.push(p);
            qStack.push(q);
            while (!pStack.isEmpty() && !qStack.isEmpty()) {
                p = pStack.pop();
                q = qStack.pop();
                if (p.val != q.val) {
                    return false;
                }
                if (p.left == null ^ q.left == null) {
                    return false;
                }
                if (p.right == null ^ q.right == null) {
                    return false;
                }
                if (p.left != null) {
                    pStack.push(p.left);
                }
                if (p.right != null) {
                    pStack.push(p.right);
                }
                if (q.left != null) {
                    qStack.push(q.left);
                }
                if (q.right != null) {
                    qStack.push(q.right);
                }
            }
            return pStack.isEmpty() && qStack.isEmpty();
        }
    }
}
