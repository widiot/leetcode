package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class Q111 {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null) return minDepth(root.right) + 1;
            if (root.right == null) return minDepth(root.left) + 1;
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    class Solution1 {
        private class QueueNode {
            public TreeNode node;
            public int depth;

            public QueueNode(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }

        public int minDepth(TreeNode root) {
            // 层序遍历，记录每一层的高度，当前层有叶子节点，则直接返回高度
            if (root == null) return 0;
            LinkedList<QueueNode> queue = new LinkedList<>();
            queue.offer(new QueueNode(root, 1));
            while (!queue.isEmpty()) {
                QueueNode queueNode = queue.poll();
                if (queueNode.node.left == null && queueNode.node.right == null) return queueNode.depth;
                if (queueNode.node.left != null) queue.offer(new QueueNode(queueNode.node.left, queueNode.depth + 1));
                if (queueNode.node.right != null) queue.offer(new QueueNode(queueNode.node.right, queueNode.depth + 1));
            }
            return 0;
        }
    }
}
