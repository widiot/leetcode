package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层次遍历 II
 */
public class Q107 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.levelOrderBottom(TreeNode.get1()));
        System.out.println(solution.levelOrderBottom(TreeNode.get2()));
        System.out.println(solution.levelOrderBottom(TreeNode.get3()));
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        /**
         * 官方的
         */
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> curLevel = new ArrayList<>();
                int curSize = queue.size();
                for (int i = 0; i < curSize; ++i) {
                    TreeNode curNode = queue.poll();
                    curLevel.add(curNode.val);
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                    }
                }
                result.add(0, curLevel);
            }
            return result;
        }

        /**
         * 自己的
         */
        public List<List<Integer>> levelOrderBottom1(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode n;
            boolean odd = true;
            int oddNum = 1, evenNum = 0;
            List<List<Integer>> result = new LinkedList<>();
            result.add(new LinkedList<>());
            while (!queue.isEmpty()) {
                n = queue.poll();
                if (n.left != null) {
                    queue.offer(n.left);
                    if (odd) {
                        ++evenNum;
                    } else {
                        ++oddNum;
                    }
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    if (odd) {
                        ++evenNum;
                    } else {
                        ++oddNum;
                    }
                }
                if (odd) {
                    --oddNum;
                    result.get(0).add(n.val);
                    if (oddNum == 0) {
                        odd = false;
                        if (!queue.isEmpty()) {
                            result.add(0, new LinkedList<>());
                        }
                    }
                } else {
                    --evenNum;
                    result.get(0).add(n.val);
                    if (evenNum == 0) {
                        odd = true;
                        if (!queue.isEmpty()) {
                            result.add(0, new LinkedList<>());
                        }
                    }
                }
            }
            return result;
        }
    }
}