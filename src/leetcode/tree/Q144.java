package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Q144 {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            // 递归
            List<Integer> list = new ArrayList<>();
            func(root, list);
            return list;
        }

        public void func(TreeNode root, List<Integer> list) {
            if (root == null) return;
            list.add(root.val);
            func(root.left, list);
            func(root.right, list);
        }
    }

    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            // 迭代：前序遍历
            if (root == null) return new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    list.add(root.val);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            return list;
        }
    }

    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            // 迭代
            if (root == null) return new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                if (root.right != null) stack.push(root.right);
                if (root.left != null) stack.push(root.left);
            }
            return list;
        }
    }
}
