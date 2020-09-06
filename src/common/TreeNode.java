package common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * ** 3
     * * / \
     * *9  20
     * ** /  \
     * * 15   7
     */
    public static TreeNode get1() {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        return n1;
    }

    /**
     * **20
     * ****\
     * *****7
     */
    public static TreeNode get11() {
        TreeNode n1 = new TreeNode(20);
        n1.right = new TreeNode(7);
        return n1;
    }

    /**
     * ******* 1
     * **** /    \
     * ****2      2
     * * /  \
     * *3   3
     * *  /  \
     * * 4   4
     */

    public static TreeNode get2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;
        return n1;
    }

    /**
     * ******* 1
     * **** /    \
     * ****2      2
     * * /  \   /  \
     * *3   4  4   3
     */
    public static TreeNode get3() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        return n1;
    }
}