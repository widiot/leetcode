package offer.tree;

import common.TreeNode;

/**
 * 平衡二叉树
 */
public class Q55Q2 {
    public static void main(String[] args) {
        System.out.println(isBalanced(TreeNode.get1()));
        System.out.println(isBalanced(TreeNode.get2()));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = h(root.left);
        int r = h(root.right);
        if (Math.abs(l - r) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int h(TreeNode n) {
        if (n == null) {
            return 0;
        }
        int l = h(n.left);
        int r = h(n.right);
        return l > r ? l + 1 : r + 1;
    }
}
