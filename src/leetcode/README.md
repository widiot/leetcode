# LeetCode精选

## 基础

* 时间复杂度要求O(NlogN)，就暗含这要用二分法，比如二分搜索、归并排序
* 空间复杂度要求常量时间，意味着不能用集合和递归，只能用迭代

## 链表

链表种类
* 单向链表
* 双向链表
* 循环链表
* 多级双向链表：多级双向链表的节点有next、pre和child，结构上可以看作树，child为树节点的left，next为树节点的right，pre为指向父节点的指针。所以对多级双向链表的操作都可以类比为对树的操作

解题方法
* 递归
* 多指针、快慢指针
* 单链表连接成环，解决旋转问题
* dummy节点解决链表头节点和尾节点极端情况
* 只要用到了`node.next.next`的，判断条件要注意加`node!=null&&node.next!=null`
* 要处理当前节点，需要保留他的前置节点`pre`，用`pre.next`操作
* 链表的难点就在于不能随机访问，所以没有思路的时候，可以把链表拆成列表进行处理，也算是一种思路，但是违背链表的初衷
* 递归相当于一个栈，如果需要从链表的尾节点开始处理，就可以使用递归
* 人工review代码，用最简单的情况去检验代码的正确性，一个节点、两个节点的情况
* 链表排序方法：归并排序、插入排序 
* 递归时，要返回从头到尾的节点顺序，可以用头插法
* 删除节点的两种方法
    * `pre,cur`双指针删除，适用于知道头节点的情况
    * `cur.val=cur.next.val`，适用于不知道头节点，删除的节点也不是尾节点的情况

## 树

树的种类
* 二叉树
* 二叉搜索树
* 平衡二叉搜索树

树的遍历方法
* 深度优先遍历（迭代、递归）
    * 前序遍历、中序遍历、后序遍历
* 广度优先遍历（迭代）
    * 层次遍历

递归遍历模板
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        func(root, list);
        return list;
    }

    public void func(TreeNode root, List<Integer> list) {
        if (root == null) return;
        // list.add(root.val); // 前序遍历
        func(root.left, list);
        // list.add(root.val); // 中序遍历
        func(root.right, list);
        // list.add(root.val); // 后序遍历
    }
}
```

迭代遍历模板
```java
class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // list.add(0, root.val); // 前序遍历
                root = root.right;
            }
            root = stack.pop();
            // list.add(0, root.val); // 中序遍历
            root = root.left;
            // 中序遍历，实现略有不同
        }
        return list;
    }
}
```

层序遍历模板
```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> tList=new ArrayList<>();
            while(size-->0){
                root=queue.poll();
                if(root.left!=null) queue.offer(root.left);
                if(root.right!=null) queue.offer(root.right);
                tTist.add(root.val);
            }
            list.add(tList);
        }
        return list;
    }
}
```

解题方法
* 递归：树的思路很容易从递归去思考，很多性质，对于树的左子树和右子树都是同样适用的
* 栈和队列：递归其实对应的相当于隐式的栈
* 二叉搜索树的常用性质
    * 左子树小于根节点，右子树大于根节点
    * 二叉搜索树的中序遍历是有序数组
* 思考树的递归时，从最简单的情况开始考虑，当树=null时、当树只有一个左孩子、当树有左孩子和孩子等等思考下去
* 树的遍历中，存在root，则可以操作root层，和下一层
* 计算树的复杂度时，考虑完全二叉树，和退化成链表，两种极端情况