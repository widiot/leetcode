package offer.array;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 */
public class Q45 {
    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{10, 2}));
    }

    public static String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, ((x, y) -> (x + y).compareTo(y + x)));
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }
}
