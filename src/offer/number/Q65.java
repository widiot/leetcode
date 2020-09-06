package offer.number;

/**
 * 不用加减乘除做加法
 */
public class Q65 {
    public static void main(String[] args) {
        System.out.println(add(10, 20));
        System.out.println(add(10, -2));
        System.out.println(add(-10, 2));
        System.out.println(add(-10, -2));
    }

    public static int add(int a, int b) {
        int sum, move;
        do {
            sum = a ^ b;
            move = (a & b) << 1;
            a = sum;
            b = move;
        } while (move != 0);
        return sum;
    }
}
