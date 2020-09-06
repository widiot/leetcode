package offer.linkedlist;

import java.util.HashMap;

/**
 * 复杂链表的复制
 */
public class Q35 {
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        Node newHead = copyRandomList(n1);
        while (newHead != null) {
            System.out.println(newHead.val + " " + (newHead.random == null ? "" : newHead.random.val));
            newHead = newHead.next;
        }

        Node n6 = new Node(3);
        Node n7 = new Node(3);
        Node n8 = new Node(3);
        n6.next = n7;
        n7.next = n8;
        n7.random = n6;
        newHead = copyRandomList(n6);
        while (newHead != null) {
            System.out.println(newHead.val + " " + (newHead.random == null ? "" : newHead.random.val));
            newHead = newHead.next;
        }


    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node curOld = head, curNew, newHead;
        newHead = new Node(curOld.val);
        curNew = newHead;
        map.put(head, newHead);
        while (curOld != null) {
            if (curOld.next != null) {
                if (map.containsKey(curOld.next)) {
                    curNew.next = map.get(curOld.next);
                } else {
                    Node node = new Node(curOld.next.val);
                    map.put(curOld.next, node);
                    curNew.next = node;
                }
            }
            if (curOld.random != null) {
                if (map.containsKey(curOld.random)) {
                    curNew.random = map.get(curOld.random);
                } else {
                    Node node = new Node(curOld.random.val);
                    map.put(curOld.random, node);
                    curNew.random = node;
                }
            }
            curOld = curOld.next;
            curNew = curNew.next;
        }
        return newHead;
    }
}
