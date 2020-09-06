package offer.recursion;

/**
 * 剪绳子
 */
public class Q14 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(24));
    }

    public static int cuttingRope(int n) {
        if (n <= 3) {
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
        }
        int times3 = n / 3;
        int times2or4 = n % 3;
        if (times2or4 == 1) {
            times3--;
        }
        return (int) Math.pow(3, times3) * (times2or4 == 0 ? 1 : (times2or4 == 1 ? 4 : 2));
    }
}
