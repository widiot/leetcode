package common;

import java.util.LinkedList;

public class PrintUtil {

    public static void printLinkedList(ListNode l) {
        while (l != null) {
            System.out.print(l.val);
            if (l.next != null) {
                System.out.print(" -> ");
            }
            l = l.next;
        }
    }

    public static void printBinaryTree(TreeNode r) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(r);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode n = queue.poll();
                System.out.print(n.val + " ");
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
            System.out.println();
        }
    }
}
