package offer.recursion;

import java.util.Arrays;

/**
 * n个骰子的点数
 */
public class Q60 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(1)));
        System.out.println(Arrays.toString(twoSum(2)));
        System.out.println(Arrays.toString(twoSum(3)));
    }

    public static double[] twoSum(int n) {
        int[] arr = new int[6 * n - n + 1];
        Arrays.fill(arr, 0);
        for (int i = 1; i <= 6; ++i) {
            func(n, 1, i, arr);
        }
        double[] d = new double[arr.length];
        double sum = 0.0;
        for (int value : arr) {
            sum += value;
        }
        for (int i = 0; i < arr.length; ++i) {
            d[i] = arr[i] / sum;
        }
        return d;
    }

    public static void func(int n, int curN, int curD, int[] arr) {
        if (n == curN) {
            arr[curD - n]++;
            return;
        }
        for (int i = 1; i <= 6; ++i) {
            func(n, curN + 1, curD + i, arr);
        }
    }
}
