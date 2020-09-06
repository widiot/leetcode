package offer.tree;

import java.util.Arrays;

/**
 * 重建二叉树
 */
public class Q07 {
    public static void main(String[] args) {

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[0]);
        int idx;
        for (idx = 0; idx < inorder.length; ++idx) {
            if (inorder[idx] == preorder[0]) {
                break;
            }
        }
        head.left = buildTree(Arrays.copyOfRange(preorder, 1, idx + 1), Arrays.copyOfRange(inorder, 0, idx));
        head.right = buildTree(Arrays.copyOfRange(preorder, idx + 1, preorder.length), Arrays.copyOfRange(inorder, idx + 1, inorder.length));
        return head;
    }
}
