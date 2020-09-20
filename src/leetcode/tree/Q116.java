package leetcode.tree;

import common.Node;

import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Q116 {
    class Solution {
        public Node connect(Node root) {
            // 递归
            if (root == null) return null;
            if (root.left != null && root.right != null)
                root.left.next = root.right; // 这里已经操作了root的左右孩子的next，所以下一层能通过root.next访问到
            if (root.next != null && root.right != null) root.right.next = root.next.left;
            connect(root.left);
            connect(root.right);
            return root;
        }
    }

    class Solution1 {
        public Node connect(Node root) {
            // 迭代，没有new，不算使用新空间
            if (root == null) return root;
            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Node cur = queue.poll();
                    if (size > 0) cur.next = queue.peek();
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
            }
            return root;
        }
    }
}
