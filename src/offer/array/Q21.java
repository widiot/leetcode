package offer.array;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class Q21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }

    public static int[] exchange(int[] nums) {
        int[] a = new int[nums.length];
        for (int i = 0, k = 0, j = nums.length - 1; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                a[k++] = nums[i];
            } else {
                a[j--] = nums[i];
            }
        }
        return a;
    }
}
