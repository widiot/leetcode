package offer.number;

/**
 * 丑数
 */
public class Q49 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(100));
    }

    public static int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] a = new int[n];
        a[0] = 1;
        int nxt = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int min;
        while (nxt < n) {
            min = Math.min(Math.min(a[p2] * 2, a[p3] * 3), a[p5] * 5);
            a[nxt++] = min;
            while (a[p2] * 2 <= min) {
                p2++;
            }
            while (a[p3] * 3 <= min) {
                p3++;
            }
            while (a[p5] * 5 <= min) {
                p5++;
            }
        }
        return a[n - 1];
    }
}
