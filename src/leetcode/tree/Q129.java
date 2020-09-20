package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 129. 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class Q129 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(TreeNode.get1()));
    }

    static class Solution {
        public int sumNumbers(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            func(root, list, new StringBuilder());
            return list.stream().reduce(Integer::sum).orElse(0);
        }

        public void func(TreeNode root, List<Integer> list, StringBuilder path) {
            if (root == null) {
                return;
            }
            path.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                list.add(Integer.parseInt(path.toString()));
            }
            func(root, list, path);
            func(root, list, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    class Solution1 {
        public int sumNumbers(TreeNode root) {
            // 层次遍历，保存到当前层时的路径
            if (root == null) {
                return 0;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            LinkedList<Integer> path = new LinkedList<>();
            queue.offer(root);
            path.offer(root.val);
            int sum = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    root = queue.poll();
                    int temp = path.poll();
                    if (root.left == null && root.right == null) {
                        sum += temp;
                    } else {
                        if (root.left != null) {
                            queue.offer(root.left);
                            path.offer(temp * 10 + root.left.val);
                        }
                        if (root.right != null) {
                            queue.offer(root.right);
                            path.offer(temp * 10 + root.right.val);
                        }
                    }
                }
            }
            return sum;
        }
    }
}
