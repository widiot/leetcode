package offer.tree;

import common.TreeNode;

/**
 * 对称的二叉树
 */
public class Q28 {
    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNode.get3()));
    }

    public static boolean isSymmetric(TreeNode root) {
        return preorder(root, root);
    }

    public static boolean preorder(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.val != n2.val) {
            return false;
        }
        return preorder(n1.left, n2.right) && preorder(n1.right, n2.left);
    }
}
