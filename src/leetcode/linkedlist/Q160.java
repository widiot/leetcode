package leetcode.linkedlist;

import common.ListNode;

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class Q160 {

    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 让节点多的先走几步，然后一起走，直到碰面
            if (headA == null || headB == null) {
                return null;
            }
            int aLen = 0, bLen = 0;
            ListNode aCur = headA, bCur = headB;
            while (aCur != null) {
                ++aLen;
                aCur = aCur.next;
            }
            while (bCur != null) {
                ++bLen;
                bCur = bCur.next;
            }
            aCur = headA;
            bCur = headB;
            if (aLen > bLen) {
                for (int i = 0; i < (aLen - bLen); ++i) {
                    aCur = aCur.next;
                }
            } else {
                for (int i = 0; i < (bLen - aLen); ++i) {
                    bCur = bCur.next;
                }
            }
            while (aCur != null) {
                if (aCur == bCur) {
                    return aCur;
                }
                aCur = aCur.next;
                bCur = bCur.next;
            }
            return null;
        }
    }

    public static class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 官方解法，双指针交替遍历，走过相同的路程到达交点
            if (headA == null || headB == null) {
                return null;
            }

            ListNode a = headA, b = headB, at = null, bt = null;
            while ((at == null || bt == null) || at != bt) {
                if (a == b) {
                    return a;
                }

                if (a == null) {
                    a = headB;
                } else if (a.next == null) {
                    at = a;
                    a = a.next;
                } else {
                    a = a.next;
                }

                if (b == null) {
                    b = headA;
                } else if (b.next == null) {
                    bt = b;
                    b = b.next;
                } else {
                    b = b.next;
                }
            }

            return null;
        }
    }
}
