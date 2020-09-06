package offer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树两个节点的最低公共祖先
 */
public class Q68 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        System.out.println(lowestCommonAncestor(n1, n2, n4).val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        func(root, l1, p);
        func(root, l2, q);
        int i, min = Math.min(l1.size(), l2.size());
        for (i = 0; i < min; ++i) {
            if (l1.get(i).val != l2.get(i).val) {
                break;
            }
        }
        return l1.get(i - 1);
    }

    public static void func(TreeNode root, List<TreeNode> l, TreeNode n) {
        if (root == null) {
            return;
        }
        l.add(root);
        if (root.val > n.val) {
            func(root.left, l, n);
        } else if (root.val < n.val) {
            func(root.right, l, n);
        }
    }
}
