package offer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第k大节点
 */
public class Q54 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n3.left = n1;
        n1.right = n2;
        n3.right = n4;
        System.out.println(kthLargest(n3, 1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        fun(root, list, k);
        return list.get(list.size() - 1);
    }

    public static void fun(TreeNode root, List<Integer> list, int k) {
        if (root == null) {
            return;
        }
        fun(root.right, list, k);
        if (list.size() == k) {
            return;
        }
        list.add(root.val);
        fun(root.left, list, k);
    }
}
