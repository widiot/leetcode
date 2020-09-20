package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class Q95 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateTrees(3);
    }

    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            return func(1, n);
        }

        public List<TreeNode> func(int start, int end) {
            List<TreeNode> list = new ArrayList<>();
            if (start > end) {
                list.add(null);
                return list;
            }
            List<TreeNode> leftList, rightList;
            for (int i = start; i <= end; ++i) {
                leftList = func(start, i - 1);
                rightList = func(i + 1, end);
                for (TreeNode leftRoot : leftList) {
                    for (TreeNode rightRoot : rightList) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftRoot;
                        root.right = rightRoot;
                        list.add(root);
                    }
                }
            }
            return list;
        }
    }
}
