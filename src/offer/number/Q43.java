package offer.number;

/**
 * 1~n整数中1出现的次数
 */
public class Q43 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(12));
    }

    public static int countDigitOne(int n) {
        int h = n / 10;
        int c = n % 10;
        int l = 0;
        int d = 1;

        int sum = 0;

        while (h != 0 || c != 0) {
            if (c == 0) {
                sum += h * d;
            } else if (c == 1) {
                sum += h * d + l + 1;
            } else {
                sum += (h + 1) * d;
            }
            l += c * d;
            c = h % 10;
            h /= 10;
            d *= 10;
        }
        return sum;
    }
}

