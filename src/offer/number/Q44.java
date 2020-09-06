package offer.number;

/**
 * 数字序列中某一位的数字
 */
public class Q44 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(3)); // 3
        System.out.println(findNthDigit(10)); // 1
        System.out.println(findNthDigit(11)); // 0
        System.out.println(findNthDigit(100)); // 5
        System.out.println(findNthDigit(1001)); // 7
        System.out.println(findNthDigit(1000000)); // 1
        System.out.println(findNthDigit(1000000000)); // 1
    }

    public static int findNthDigit(int n) {
        int i = 1;
        long num,t;
        while (true) {
            num = getSum(i);
            t = num * i;
            if ((n - t) < 0) {
                return getNum(i, n);
            }
            n -= t;
            ++i;
        }
    }

    public static int getNum(int i, int n) {
        // i位数的第n个数字
        int base = (n / i) + (i == 1 ? 0 : (int) Math.pow(10, i - 1));
        int p = n - ((n / i) * i);
        for (int k = p; k < (i - 1); ++k) {
            base = base / 10;
        }
        return base % 10;
    }

    public static int getSum(int i) {
        // 返回i位数的总数
        if (i == 1) {
            return 10;
        }
        return (int) Math.pow(10, i) - (int) Math.pow(10, i - 1);
    }
}
