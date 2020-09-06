package offer.array;

import java.util.Arrays;

/**
 * 和为s的两个数字
 */
public class Q57 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(a, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int t;
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if ((t = nums[i] + nums[j]) == target) {
                return new int[]{nums[i], nums[j]};
            } else if (t > target) {
                j--;
            } else {
                i--;
            }
        }
        return new int[0];
    }
}
