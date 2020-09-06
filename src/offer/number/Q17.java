package offer.number;

import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 */
public class Q17 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(3)));
    }

    public static int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int len = 10;
        for (int i = n; i > 1; i--) {
            len *= 10;
        }
        len--;
        int[] r = new int[len];
        for (int i = 1; i <= len; i++) {
            r[i - 1] = i;
        }
        return r;
    }
}
