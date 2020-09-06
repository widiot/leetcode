package offer.array;

import java.util.Arrays;

/**
 * 构建乘积数组
 */
public class Q66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArr(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] constructArr(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }
        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = a[i - 1] * b[i - 1];
        }
        int t = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            t *= a[i + 1];
            b[i] *= t;
        }
        return b;
    }
}
