package leetcode.tree;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class Q96 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }

    static class Solution {
        public int numTrees(int n) {
            // Q94递归，超时
            if (n <= 0) {
                return 0;
            }
            return func(1, n);
        }

        public int func(int start, int end) {
            int sum = 1;
            for (int i = start; i <= end; ++i) {
                int leftSum = func(start, i - 1);
                int rightSum = func(i + 1, end);
                sum = leftSum * rightSum;
            }
            return sum;
        }
    }

    class Solution1 {
        public int numTrees(int n) {
            // f(i,n)=g(i-1)*g(i+1)
            // g(n)=g(i-1)*g(n-i),从1开始到n求和
            //
            // 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
            // G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
            // 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
            // f(i)=G(i−1)∗G(n−i)
            // 综合两个公式可以得到 卡特兰数 公式
            // G(n)=G(0)∗G(n−1)+G(1)∗G(n−2)+...+G(n−1)∗G(0)
            int[] G = new int[n + 1];
            G[0] = 1;
            G[1] = 1;
            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }
}
