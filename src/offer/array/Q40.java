package offer.array;

import java.util.Arrays;

/**
 * 最小的k个数
 */
public class Q40 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{1, 2, 3, 4, 5}, 3)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[0];
        }
        quick(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void quick(int[] arr, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int i = start, j = end, t = arr[start];
        while (i < j) {
            while (i < j && arr[j] >= t) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] <= t) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = t;
        if (i > k) {
            quick(arr, start, i - 1, k);
        } else if (i < k) {
            quick(arr, i + 1, end, k);
        }
    }
}
