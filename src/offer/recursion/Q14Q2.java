package offer.recursion;

/**
 * 剪绳子，大数问题
 */
public class Q14Q2 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(8)); // 18
        System.out.println(cuttingRope(2)); // 1
        System.out.println(cuttingRope(10)); // 10
        System.out.println(cuttingRope(100)); // 10
    }

    public static int cuttingRope(int n) {
        if (n == 3) return 2;
        long result = 1;
        while (n > 2) {
            n -= 3;
            if (n >= 3 || n == 0) {
                result *= 3;
            } else if (n == 1) {
                result *= 4;
            } else if (n == 2) {
                result *= 6;
            }
            result %= 1000000007;
        }
        return (int) result;
    }
}
