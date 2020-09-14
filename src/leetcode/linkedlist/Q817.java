package leetcode.linkedlist;

import common.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 817. 链表组件
 * https://leetcode-cn.com/problems/linked-list-components/
 */
public class Q817 {

    class Solution {
        public int numComponents(ListNode head, int[] G) {
            Set<Integer> set = Arrays.stream(G).boxed().collect(Collectors.toSet());
            ListNode left = head, right = head;
            int sum = 0;
            while (right != null) {
                if (set.contains(right.val)) {
                    right = right.next;
                } else {
                    if (left != right) {
                        ++sum;
                    }
                    right = right.next;
                    left = right;
                }
            }
            if (left != right) {
                ++sum;
            }
            return sum;
        }
    }

    class Solution1 {
        public int numComponents(ListNode head, int[] G) {
            // 当前节点在数组中，而下一个节点不在，则当前节点是一个组件的尾节点
            Set<Integer> set = new HashSet<>();
            for (int i : G) set.add(i);

            ListNode cur = head;
            int sum = 0;
            while (cur != null) {
                if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))) {
                    ++sum;
                    cur = cur.next == null ? null : cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            return sum;
        }
    }
}
