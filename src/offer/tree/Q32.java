package offer.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 从上到下打印二叉树
 */
public class Q32 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n1.left = n9;
        n1.right = n20;
        n20.left = n15;
        n20.right = n7;
        System.out.println(Arrays.toString(levelOrder(n1)));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode cur;
        queue.offer(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            result.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
