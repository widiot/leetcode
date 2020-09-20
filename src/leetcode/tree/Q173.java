package leetcode.tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 173. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class Q173 {
    class BSTIterator {
        private TreeNode next;

        public BSTIterator(TreeNode root) {
            next = func(root);
        }

        /**
         * 将树转为链表
         */
        private TreeNode func(TreeNode root) {
            if (root == null) return null;
            if (root.left == null) {
                root.right = func(root.right); // 节点没有左子树，则当前节点即为链表最左节点，递归处理右子树，并赋给当前节点
                return root;
            }
            TreeNode head = func(root.left); // 返回链表最左节点
            TreeNode left = root.left;
            while (left.right != null) left = left.right; // 左子树最右节点连接到当前节点
            left.right = root;
            root.left = null;
            root.right = func(root.right);
            return head;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (next == null) return 0;
            TreeNode old = next;
            next = next.right;
            return old.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return next != null;
        }
    }

    class BSTIterator1 {
        private LinkedList<TreeNode> stack;

        public BSTIterator1(TreeNode root) {
            stack=new LinkedList<>();
            func(root);
        }

        private void func(TreeNode root){
            // 受控递归，将递归的结果暂存在栈中，每次访问时再进行下一次递归
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            if(!hasNext()) return 0;
            TreeNode smallest=stack.pop();
            if(smallest.right!=null) func(smallest.right);
            return smallest.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
