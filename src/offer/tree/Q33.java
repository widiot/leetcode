package offer.tree;

/**
 * 二叉搜索树的后序遍历序列
 */
public class Q33 {
    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 2, 3, 4, 5}));
    }

    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length <= 2) {
            return true;
        }
        return func(postorder, 0, postorder.length - 1);
    }

    public static boolean func(int[] postorder, int start, int end) {
        if (start < end - 1) {
            int p1 = start - 1, p2 = end;
            int root = postorder[end];
            while (p1 < p2 && postorder[p1 + 1] < root) {
                ++p1;
            }
            while (p2 > start && postorder[p2 - 1] > root) {
                --p2;
            }
            if (!((p1 == p2 - 1) || (p1 == p2 && (p1 == start || p2 == end - 1)))) {
                return false;
            }
            return func(postorder, start, p1) && func(postorder, p2, end - 1);
        }
        return true;
    }
}
