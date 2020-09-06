package offer.number;

/**
 * 圆圈中最后剩下的数字
 */
public class Q62 {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }

    public static int lastRemaining(int n, int m) {
        int pos = 0;
        for (int i = 2; i <= n; ++i) {
            pos = (pos + m) % i;
        }
        return pos;
    }
}
