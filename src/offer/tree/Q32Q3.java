package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 之字形打印二叉树
 */
public class Q32Q3 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        TreeNode n6 = new TreeNode(10);
        TreeNode n7 = new TreeNode(11);
        n2.left = n6;
        n6.left = n7;

        System.out.println(levelOrder(n1));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> leftToRight = new LinkedList<>();
        LinkedList<TreeNode> rightToLeft = new LinkedList<>();
        leftToRight.offer(root);
        TreeNode cur;
        while (leftToRight.size() != 0 || rightToLeft.size() != 0) {
            List<Integer> list = new ArrayList<>();
            if (leftToRight.size() != 0) {
                while (leftToRight.size() != 0) {
                    cur = leftToRight.removeFirst();
                    list.add(cur.val);
                    if (cur.left != null) {
                        rightToLeft.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        rightToLeft.addLast(cur.right);
                    }
                }
            } else if (rightToLeft.size() != 0) {
                while (rightToLeft.size() != 0) {
                    cur = rightToLeft.removeLast();
                    list.add(cur.val);
                    if (cur.right != null) {
                        leftToRight.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        leftToRight.addFirst(cur.left);
                    }
                }
            }
            if (list.size() != 0) {
                result.add(list);
            }
        }
        return result;
    }
}
