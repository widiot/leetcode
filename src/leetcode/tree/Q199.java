package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class Q199 {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    root = queue.poll();
                    if (root.left != null) queue.offer(root.left);
                    if (root.right != null) queue.offer(root.right);
                    if (size == 0) list.add(root.val);
                }
            }
            return list;
        }
    }

    class Solution1 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            func(root, list, 0);
            return list;
        }

        public void func(TreeNode root, List<Integer> list, int depth) {
            if (root == null) return;
            if (depth == list.size()) list.add(root.val);
            ++depth;
            func(root.right, list, depth);
            func(root.left, list, depth);
        }
    }
}
