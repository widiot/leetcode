package offer.array;

import java.util.Arrays;

/**
 * 数组中出现次数超过一半的数字
 */
public class Q39 {
    public static void main(String[] args) {
        int[] array = new int[]{32, 41, 21, 29, 7, 53, 97, 76, 71, 53, 53, 53, 72, 53, 53, 14, 22, 53, 67, 53, 53, 53, 54, 98, 53, 46, 53, 53, 62, 53, 76, 20, 60, 53, 31, 53, 53, 53, 95, 27, 53, 53, 53, 53, 36, 59, 40, 53, 53, 64, 53, 53, 53, 21, 53, 51, 53, 53, 2, 53, 53, 53, 53, 53, 50, 53, 53, 53, 23, 88, 3, 53, 61, 19, 53, 68, 53, 35, 42, 53, 53, 48, 34, 54, 53, 75, 53, 53, 50, 44, 92, 41, 71, 53, 53, 82, 53, 53, 14, 53};
        System.out.println(majorityElement(array));
        System.out.println(Arrays.toString(array));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length <= 2) {
            return nums[0];
        }
        quick(nums, 0, nums.length - 1);
        return nums[nums.length >> 1];
    }

    public static void quick(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = nums[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] >= temp) {
                --j;
            }
            if (i < j) {
                nums[i] = nums[j];
                ++i;
            }
            while (i < j && nums[i] <= temp) {
                ++i;
            }
            if (i < j) {
                nums[j] = nums[i];
                --j;
            }
        }
        nums[i] = temp;
        int half = nums.length >> 1;
        if (i < half) {
            quick(nums, i + 1, end);
        } else if (i > half) {
            quick(nums, start, i - 1);
        }
    }
}
