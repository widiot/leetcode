package offer.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为s的连续正数序列
 */
public class Q57Q2 {
    public static void main(String[] args) {
        int[][] a = findContinuousSequence(87760);
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] findContinuousSequence(int target) {
        if (target <= 2) {
            return null;
        }
        List<int[]> l = new ArrayList<>();
        int half = (int) Math.ceil(target / 2.0);
        int min = 1, max = 2, sum = 3;
        while (min < half) {
            if (sum < target) {
                max++;
                sum += max;
            } else if (sum > target) {
                sum -= min;
                min++;
            } else {
                int[] a = new int[max - min + 1];
                for (int i = min; i <= max; i++) {
                    a[i - min] = i;
                }
                l.add(a);
                max++;
                sum += max;
            }
        }
        return l.toArray(new int[0][]);
    }
}
