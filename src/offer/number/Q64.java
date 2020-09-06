package offer.number;

/**
 * 求1+2+...+n
 */
public class Q64 {
    public static void main(String[] args) {
        System.out.println(sumNums(10));
    }

    public static int sumNums(int n) {
        int sum = 0;
        boolean b = n > 0 && (sum = (n + sumNums(n - 1))) > 0;
        return sum;
    }
}
