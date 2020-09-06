package offer.array;

import java.util.Arrays;

/**
 * 数组中数字出现的次数
 */
public class Q56 {
    public static void main(String[] args) {
        int[] array = {4, 1, 4, 6};
        System.out.println(Arrays.toString(singleNumbers(array)));
    }

    public static int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = 1;
        for (int i = 0; i < 32; ++i) {
            if ((xor & mask) != 0) {
                break;
            }
            mask <<= 1;
        }
        int[] result = {0, 0};
        for (int num : nums) {
            if ((num & mask) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
