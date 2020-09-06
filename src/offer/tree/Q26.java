package offer.tree;

import common.TreeNode;

/**
 * 树的子结构
 */
public class Q26 {
    public static void main(String[] args) {
        TreeNode n1 = TreeNode.get1();
        TreeNode n11 = TreeNode.get11();
        System.out.println(isSubStructure(n1, n11));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if (A != null && B != null) {
            if (A.val == B.val) {
                result = func(A, B);
            }
            if (!result) {
                result = isSubStructure(A.left, B);
            }
            if (!result) {
                result = isSubStructure(A.right, B);
            }
        }
        return result;
    }

    public static boolean func(TreeNode n1, TreeNode n2) {
        if (n2 == null) {
            return true;
        }
        if (n1 == null) {
            return false;
        }
        if (n1.val != n2.val) {
            return false;
        }
        return func(n1.left, n2.left) && func(n1.right, n2.right);
    }
}
