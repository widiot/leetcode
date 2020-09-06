package offer.number;

/**
 * 把数字翻译成字符串
 */
public class Q46 {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

    public static int translateNum(int num) {
        return func(Integer.toString(num));
    }

    public static int func(String s) {
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2) {
            int i = Integer.parseInt(s);
            if (i >= 10 && i <= 25) {
                return 2;
            }
            return 1;
        }
        int i = Integer.parseInt(s.substring(0, 2));
        if (i >= 10 && i <= 25) {
            return func(s.substring(1)) + func(s.substring(2));
        } else {
            return func(s.substring(1));
        }
    }
}
