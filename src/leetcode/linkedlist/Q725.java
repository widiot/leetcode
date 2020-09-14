package leetcode.linkedlist;

import common.ListNode;
import common.PrintUtil;

/**
 * 725. 分隔链表
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 */
public class Q725 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] array = solution.splitListToParts(ListNode.get1(), 3);
        PrintUtil.printLinkedArray(array);
    }

    static class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] array = new ListNode[k];

            if (k <= 0) {
                return array;
            }

            int len = 0;
            for (ListNode i = root; i != null; i = i.next) {
                ++len;
            }

            int numPerGroup = len / k;
            int remain = len % k;

            ListNode left = root, right = root;
            for (int i = 0; i < k; ++i) {
                int curSize = numPerGroup + (remain-- > 0 ? 1 : 0);
                for (int j = 1; j < curSize && right != null; ++j) {
                    right = right.next;
                }
                array[i] = left;
                if (right != null) {
                    left = right.next;
                    right.next = null;
                    right = left;
                }
            }

            return array;
        }
    }
}
