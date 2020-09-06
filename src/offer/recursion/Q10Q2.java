package offer.recursion;

/**
 * 青蛙跳台阶问题
 */
public class Q10Q2 {
    public static void main(String[] args) {
        System.out.println(numWays(2346546));
    }

    public static int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int prepre = 1, pre = 1, cur;
        for (int i = 2; i <= n; ++i) {
            cur = (pre + prepre) % 1000000007;
            prepre = pre;
            pre = cur;
        }

        return pre;
    }
}
