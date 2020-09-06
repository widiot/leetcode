package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分行从上到下打印二叉树
 */
public class Q32Q2 {
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
        List<List<Integer>> list = levelOrder(n1);
        System.out.println(list);
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
        if (root == null) {
            return new ArrayList<>();
        }
        boolean flag = true;
        int cur = 1, nxt = 0;
        LinkedList<TreeNode> s = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        s.add(root);
        List<Integer> l1 = new ArrayList<>();
        list.add(l1);
        TreeNode t;
        while (!s.isEmpty()) {
            t = s.removeFirst();
            list.get(list.size() - 1).add(t.val);
            if (t.left != null) {
                s.add(t.left);
                if (flag) {
                    nxt++;
                } else {
                    cur++;
                }
            }
            if (t.right != null) {
                s.add(t.right);
                if (flag) {
                    nxt++;
                } else {
                    cur++;
                }
            }
            if (flag) {
                --cur;
                if (cur == 0 && nxt != 0) {
                    flag = false;
                    list.add(new ArrayList<>());
                }
            } else {
                --nxt;
                if (nxt == 0 && cur != 0) {
                    flag = true;
                    list.add(new ArrayList<>());
                }
            }
        }
        return list;
    }
}
