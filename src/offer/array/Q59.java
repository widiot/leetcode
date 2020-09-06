package offer.array;

import java.util.Arrays;

/**
 * 滑动窗口的最大值
 */
public class Q59 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(a, 3)));

        int[] a1 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(a1, 1)));

        int[] a2 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(a2, 8)));

        int[] a3 = new int[]{1};
        System.out.println(Arrays.toString(maxSlidingWindow(a3, 1)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return new int[0];
        }

        int[] maxArr = new int[len - k + 1];

        int max = nums[0];
        int left = 0, right = 0;
        for (int i = k - 1; i < len; ++i) {
            // 重建窗口
            if (left == right) {
                max = nums[left];
                while ((right - left + 1) != k) {
                    ++right;
                    if (nums[right] > max) {
                        max = nums[right];
                    }
                }
                maxArr[i - k + 1] = max;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxArr[i - k + 1] = max;
                ++left;
                ++right;
            } else {
                right = ++left;
            }
        }

        return maxArr;
    }
}
