package offer.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化二叉树
 */
public class Q37 {
    public static void main(String[] args) {
        TreeNode n1 = TreeNode.get1();
        String s1 = serialize(n1);
        System.out.println(s1);
        TreeNode n2 = deserialize(s1);
        System.out.println(n2.val);
        System.out.println(n2.left.val);
        System.out.println(n2.right.val);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        presort(root, list);
        return String.join(",", list);
    }

    public static void presort(TreeNode n, List<String> list) {
        if (n == null) {
            list.add("$");
            return;
        }
        list.add(Integer.toString(n.val));
        presort(n.left, list);
        presort(n.right, list);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return de(list);
    }

    public static TreeNode de(LinkedList<String> data) {
        TreeNode n = null;
        if (data.size() > 0) {
            if (!data.getFirst().equals("$")) {
                n = new TreeNode(Integer.parseInt(data.getFirst()));
                data.removeFirst();
                n.left = de(data);
                n.right = de(data);
            } else {
                data.removeFirst();
            }
        }
        return n;
    }
}
