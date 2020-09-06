package offer.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 */
public class Q34 {
    public static void main(String[] args) {
        List<List<Integer>> list = pathSum(TreeNode.get1(), 30);
        System.out.println(list);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        find(root, sum, stack, list);
        return list;
    }

    public static void find(TreeNode n, int sum, LinkedList<Integer> stack, List<List<Integer>> list) {
        if (n == null) {
            return;
        }
        stack.push(n.val);
        if (n.left == null && n.right == null) { // 叶节点
            int temp = 0;
            for (Integer i : stack) {
                temp += i;
            }
            if (temp == sum) {
                list.add(new ArrayList<>(stack));
                Collections.reverse(list.get(list.size() - 1));
            }
        }
        if (n.left != null) {
            find(n.left, sum, stack, list);
        }
        if (n.right != null) {
            find(n.right, sum, stack, list);
        }
        stack.pop();
    }
}
