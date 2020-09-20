package leetcode.tree;

import common.Node;

import java.util.LinkedList;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class Q117 {
    class Solution {
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

    class Solution1 {
        public Node connect(Node root) {
            // 迭代：把上一层当作链表，遍历链表的每个节点，去连接下一层的每个节点，直到下一层为空
            Node dummy = new Node(0);
            dummy.next = root;
            while (dummy.next != null) {
                Node cur = dummy.next; // 换层
                dummy.next = null;
                Node tail = dummy; // 连接下一层的每个节点
                while (cur != null) {
                    if (cur.left != null) {
                        tail.next = cur.left;
                        tail = tail.next;
                    }
                    if (cur.right != null) {
                        tail.next = cur.right;
                        tail = tail.next;
                    }
                    cur = cur.next;
                }
            }
            return root;
        }
    }
}