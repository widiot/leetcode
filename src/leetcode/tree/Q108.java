package leetcode.tree;

import common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Q108 {
    public static void main(String[] args) {

    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null) return null;
            return func(nums, 0, nums.length - 1);
        }

        public TreeNode func(int[] nums, int start, int end) {
            if (start > end) return null;
            int mid = (start + end + 1) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = func(nums, start, mid - 1);
            root.right = func(nums, mid + 1, end);
            return root;
        }
    }
}
