package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Q94 {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            // 递归
            List<Integer> list = new ArrayList<>();
            func(root, list);
            return list;
        }

        public void func(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            func(root.left, list);
            list.add(root.val);
            func(root.right, list);
        }
    }

    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            // 栈
            List<Integer> list = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                // 先访问到最左子树
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                // 返回到最左子树
                root = stack.pop();
                // 访问根节点
                list.add(root.val);
                // 访问右子树
                root = root.right;
            }
            return list;
        }
    }

    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            // morris莫里斯中序遍历
            List<Integer> list = new ArrayList<>();
            TreeNode predecessor;
            while (root != null) {
                // 左子树不为空，则找到predecessor进行连接
                if (root.left != null) {
                    // 找到左子树的最右节点，防止循环引用
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root) {
                        predecessor = predecessor.right;
                    }
                    // 如果predecessor没有右孩子，则将predecessor的右孩子指向root，并访问左子树
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    }
                    // 如果有右孩子，则该右孩子只能是root，则表示root左子树已经访问完了，需要断开连接
                    else {
                        list.add(root.val);
                        predecessor.right = null;
                        root = root.right;
                    }
                }
                // 左子树为空，则直接访问右子树
                else {
                    list.add(root.val);
                    root = root.right;
                }
            }
            return list;
        }
    }
}