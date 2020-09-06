package offer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树与双向链表
 */
public class Q36 {
    public static void main(String[] args) {
        Node root = new Node(4);
        Node n2 = new Node(2);
        Node n5 = new Node(5);
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        root.left = n2;
        root.right = n5;
        n2.left = n1;
        n2.right = n3;
        Node head = treeToDoublyList(root);
        Node node = head.right;
        while (node != null && node != head) {
            System.out.println(node.val);
            node = node.right;
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> nodeList = new ArrayList<>();
        middle(root, nodeList);
        for (int i = 0; i < nodeList.size(); ++i) {
            if (i != 0) {
                nodeList.get(i).left = nodeList.get(i - 1);
            } else {
                nodeList.get(i).left = nodeList.get(nodeList.size() - 1);
            }
            if (i != nodeList.size() - 1) {
                nodeList.get(i).right = nodeList.get(i + 1);
            } else {
                nodeList.get(i).right = nodeList.get(0);
            }
        }
        return nodeList.get(0);
    }

    public static void middle(Node node, List<Node> nodeList) {
        if (node == null) {
            return;
        }
        middle(node.left, nodeList);
        nodeList.add(node);
        middle(node.right, nodeList);
    }
}
