package leetcode.linkedlist;

import common.ListNode;
import common.PrintUtil;

/**
 * 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class Q147 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l = solution.insertionSortList(ListNode.get1());
        PrintUtil.printLinkedList(l);
    }

    /**
     * 递归到尾节点，从尾节点开始处理有序区，返回新的头节点
     */
    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) { // 空或单节点，已经有序
                return head;
            }

            ListNode sortedHead = insertionSortList(head.next); // 递归到尾节点，把右边作为有序区进行插入排序

            ListNode dummy = new ListNode(0); // dummy节点处理头节点的插入
            dummy.next = sortedHead;

            ListNode pre = dummy, greater = sortedHead;
            while (greater != null && head.val > greater.val) { // 找到插入的位置
                pre = pre.next;
                greater = greater.next;
            }

            pre.next = head; // 插入到当前位置
            head.next = greater;

            return dummy.next; // 返回新的头节点
        }
    }
}