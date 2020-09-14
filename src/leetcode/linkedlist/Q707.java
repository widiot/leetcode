package leetcode.linkedlist;

/**
 * 707. 设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 */
public class Q707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(1);
        myLinkedList.print();

        myLinkedList.addAtIndex(0, 2);
        myLinkedList.print();

        myLinkedList.deleteAtIndex(0);
        myLinkedList.print();
        myLinkedList.deleteAtIndex(0);
        myLinkedList.print();
    }

    static class MyLinkedList {
        static class Node {
            public int val;
            public Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        public void print() {
            Node l = head;
            while (l != null) {
                System.out.print(l.val);
                if (l.next != null) {
                    System.out.print(" -> ");
                }
                l = l.next;
            }
            System.out.println();
        }

        private int size;
        private Node head;
        private Node tail;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (size == 0 || index < 0 || index >= size) {
                return -1;
            }
            Node p = head;
            while (--index >= 0) {
                p = p.next;
            }
            return p.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node n = new Node(val);
            n.next = head;
            head = n;
            if (tail == null) {
                tail = head;
            }
            ++size;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Node n = new Node(val);
            if (tail == null) {
                head = tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
            ++size;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index == size) {
                addAtTail(val);
                return;
            }
            if (index > size) {
                return;
            }
            if (index < 0) {
                addAtHead(val);
                return;
            }
            Node dummy = new Node(0);
            dummy.next = head;
            Node pre = dummy, cur = head;
            while (--index >= 0) {
                pre = cur;
                cur = cur.next;
            }
            Node n = new Node(val);
            n.next = pre.next;
            pre.next = n;
            if (cur == head) {
                head = dummy.next;
            } else if (cur == null) {
                tail = n;
            }
            dummy.next = null;
            ++size;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (size == 0 || index < 0 || index >= size) {
                return;
            }
            Node dummy = new Node(0);
            dummy.next = head;
            Node pre = dummy, cur = head;
            while (--index >= 0) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = pre.next.next;
            if (cur == head) {
                head = dummy.next;
            } else if (cur == tail) {
                tail = pre;
            }
            dummy.next = null;
            --size;
        }
    }
}
