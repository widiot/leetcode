package offer.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的镜像
 */
public class Q27 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        TreeNode r = mirrorTree(n1);
        System.out.println(r.val);
        System.out.println(r.left.val);
        System.out.println(r.right.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode head;
        TreeNode t;
        while (!q.isEmpty()) {
            head = q.poll();
            if (head != null) {
                q.offer(head.right);
                q.offer(head.left);
                t = head.left;
                head.left = head.right;
                head.right = t;
            }
        }
        return root;
    }
}
