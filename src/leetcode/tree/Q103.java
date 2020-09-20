package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Q103 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.zigzagLevelOrder(TreeNode.get1());
    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<List<Integer>> list = new ArrayList<>();
            TreeNode t;
            boolean odd = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> temp = new ArrayList<>(size);
                while (size-- > 0) {
                    t = queue.poll();
                    if (odd) {
                        temp.add(t.val);
                    } else {
                        temp.add(0, t.val);
                    }
                    if (t.left != null) queue.offer(t.left);
                    if (t.right != null) queue.offer(t.right);
                }
                list.add(temp);
                odd = !odd;
            }
            return list;
        }
    }
}
