package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class Q257 {
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            func(root, list, new StringBuilder());
            return list;
        }

        public void func(TreeNode root, List<String> list, StringBuilder path) {
            if (root == null) return;
            String val = Integer.toString(root.val);
            int len = val.length();
            if (path.length() != 0) {
                path.append("->");
                len += 2;
            }
            path.append(val);
            if (root.left == null && root.right == null) {
                list.add(path.toString());
            } else {
                func(root.left, list, path);
                func(root.right, list, path);
            }
            path.delete(path.length() - len, path.length());
        }
    }

    class Solution1 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            func(root, list, new StringBuilder());
            return list;
        }

        public void func(TreeNode root, List<String> list, StringBuilder path) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                list.add(path.toString() + root.val);
            } else {
                int size = path.length();
                path.append(root.val);
                path.append("->");
                func(root.left, list, path);
                func(root.right, list, path);
                path.delete(size, path.length());
            }
        }
    }

    class Solution2 {
        public List<String> binaryTreePaths(TreeNode root) {
            // 层序遍历，记录根节点到每一层的路径
            if (root == null) return new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<String> path = new LinkedList<>();
            queue.offer(root);
            path.offer(Integer.toString(root.val));
            List<String> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    root = queue.poll();
                    String temp = path.poll();
                    if (root.left == null && root.right == null) {
                        list.add(temp);
                        break;
                    }
                    if (root.left != null) {
                        queue.offer(root.left);
                        path.offer(temp + "->" + root.left.val);
                    }
                    if (root.right != null) {
                        queue.offer(root.right);
                        path.offer(temp + "->" + root.right.val);
                    }
                }
            }
            return list;
        }
    }
}
