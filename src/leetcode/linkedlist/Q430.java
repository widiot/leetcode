package leetcode.linkedlist;

import common.Node;

/**
 * 430. 扁平化多级双向链表
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class Q430 {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.prev = n1;
        n2.next = n4;
        n4.prev = n2;
        n2.child = n3;

        Solution solution = new Solution();
        Node node = solution.flatten(n1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    static class Solution {
        public Node flatten(Node head) {
            // 看起来像是把树转为双向链表，child为left，next为right
            // 本质上是树的前序遍历
            if (head == null) {
                return null;
            }
            Node node = func(head, null);
            while (node.prev != null) {
                node = node.prev;
            }
            return node;
        }

        public Node func(Node curNode, Node preNode) {
            if (curNode == null) {
                return preNode;
            }

            // 访问当前节点
            // 把当前节点和链表连接起来
            // 需要先暂存next，因为curNode.next在访问左子树时会改变
            if (preNode != null) {
                preNode.next = curNode;
                curNode.prev = preNode;
            }
            Node next = curNode.next;

            // 再访问左子树
            // 拿到左子树的preNode，并断掉child
            preNode = func(curNode.child, curNode);
            curNode.child = null;

            // 最后访问右子树
            return func(next, preNode);
        }
    }
}
