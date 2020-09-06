package offer.bit;

/**
 * 二进制中1的个数
 */
public class Q15 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(0));
    }

    public static int hammingWeight(int n) {
        int mask = 1, re = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                re++;
            }
            mask <<= 1;
        }
        return re;
    }
}
