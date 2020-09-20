package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Q102 {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<List<Integer>> list = new ArrayList<>();
            TreeNode t;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> temp = new ArrayList<>(size);
                while (size-- > 0) {
                    t = queue.poll();
                    temp.add(t.val);
                    if (t.left != null) queue.offer(t.left);
                    if (t.right != null) queue.offer(t.right);
                }
                list.add(temp);
            }
            return list;
        }
    }


}
