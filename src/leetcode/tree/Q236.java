package leetcode.tree;

import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Q236 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) return null;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) return root;
            return left == null ? right : left;
        }
    }

    class Solution1 {
        private Map<Integer, TreeNode> map = new HashMap<>();
        private Set<Integer> set = new HashSet<>();

        public void dfs(TreeNode root) {
            if (root.left != null) {
                map.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                map.put(root.right.val, root);
                dfs(root.right);
            }
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root); // 统计每个节点的父节点
            while (p != null) { // 访问p的每个父节点
                set.add(p.val);
                p = map.get(p.val);
            }
            while (q != null) {
                if (set.contains(q.val)) return q; // 如果某个父节点在p那里已经访问过，那说明这个父节点，就是公共祖先
                set.add(q.val);
                q = map.get(q.val);
            }
            return null;
        }
    }
}
