package offer.recursion;

/**
 * 斐波那契数列
 */
public class Q10 {
    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    /**
     * 少用花括号，变量名越短，内存消耗越少
     */
    public static int fib(int n) {
        if (n <= 1) return n;
        int i = 0, j = 1, t;
        for (int s = 2; s <= n; ++s) {
            t = (j + i) % 1000000007;
            i = j;
            j = t;
        }
        return j;
    }
}
