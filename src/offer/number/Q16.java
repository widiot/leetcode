package offer.number;

/**
 * 数值的整数次方
 */
public class Q16 {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2.0, -2));
        System.out.println(myPow(-2.0, -2));
        System.out.println(myPow(-2.0, -2147483648));
        System.out.println(myPow(100, 10000000));
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double res = myPow(x, n >> 1);
        res = res * res * myPow(x, n & 1); //考虑奇数和负数的情况
        return res;
    }

//    public static double myPow(double x, int n) {
//        if (x == 1 || n == 0) return 1;
//        double result = func(x, Math.abs((long) n));
//        if (n < 0) result = 1 / result;
//        return result;
//    }
//
//    public static double func(double x, long n) {
//        if (n == 0) return 1;
//        if (n == 1) return x;
//        double result = func(x, n >> 1);
//        result *= result;
//        if ((n & 1) == 1) {
//            result *= x;
//        }
//        return result;
//    }
}
