package leetcode.linkedlist;

import common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class Q138 {
    public static void main(String[] args) {

    }

    static class Solution {
        public Node copyRandomList(Node head) {
            // 空间换时间

            if (head == null) {
                return null;
            }

            Map<Node, Node> map = new HashMap<>();
            Node cur = head, newHead = new Node(head.val), newCur = newHead;

            map.put(head, newHead);
            cur = cur.next;

            while (cur != null) {
                Node node = new Node(cur.val);
                map.put(cur, node);
                newCur.next = node;
                newCur = newCur.next;
                cur = cur.next;
            }

            cur = head;
            newCur = newHead;
            while (cur != null) {
                newCur.random = map.get(cur.random);
                cur = cur.next;
                newCur = newCur.next;
            }

            return newHead;
        }
    }
}
