package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class Q145 {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            // 递归
            List<Integer> list = new ArrayList<>();
            func(root, list);
            return list;
        }

        public void func(TreeNode root, List<Integer> list) {
            if (root == null) return;
            func(root.left, list);
            func(root.right, list);
            list.add(root.val);
        }
    }

    class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            // 迭代
            if (root == null) return new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    list.add(0, root.val);
                    root = root.right;
                }
                root = stack.pop();
                root = root.left;
            }
            return list;
        }
    }

    class Solution2 {
        public List<Integer> postorderTraversal(TreeNode root) {
            // 迭代
            if (root == null) return new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                root = stack.pop();
                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }
                list.add(0, root.val);
            }
            return list;
        }
    }

    class Solution3 {
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || (!list.isEmpty() && list.get(list.size() - 1).equals(root.right.val))) {
                    list.add(root.val);
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
            return list;
        }
    }
}

