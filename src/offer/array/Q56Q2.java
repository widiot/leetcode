package offer.array;

/**
 * 数列中唯一的数
 */
public class Q56Q2 {
    public static void main(String[] args) {
        int[] a = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(singleNumber(a));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] bitSum = new int[32];
        int bitMask;
        for (int num : nums) {
            bitMask = 1;
            for (int j = 0; j < 32; ++j) {
                if ((num & bitMask) != 0) {
                    bitSum[j]++;
                }
                bitMask <<= 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; --i) {
            res <<= 1;
            res += bitSum[i] % 3;
        }
        return res;
    }
}
