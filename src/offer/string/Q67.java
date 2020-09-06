package offer.string;

/**
 * 把字符串转换成整数
 */
public class Q67 {
    public static void main(String[] args) {
        System.out.println(strToInt("42"));
        System.out.println(strToInt("   -42"));
        System.out.println(strToInt("4193 with words"));
        System.out.println(strToInt("words and 987"));
        System.out.println(strToInt("-91283472332"));
        System.out.println(strToInt("  0000000000012345678"));
        System.out.println(strToInt("-2147483649"));
    }

    public static int strToInt(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        StringBuilder sb = new StringBuilder();
        int i = 0, symbol = 1;
        if (!isDigit(str.charAt(i))) {
            if (str.charAt(i) == '+') {
                ++i;
            } else if (str.charAt(i) == '-') {
                symbol = -1;
                ++i;
            } else {
                return 0;
            }
        }
        while (i < str.length()) {
            if (isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            } else {
                break;
            }
            ++i;
        }
        if (sb.length() > 0) {
            while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            if (sb.length() == 0) {
                return 0;
            }
            if (sb.length() > 10) {
                return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            long digit = symbol * Long.parseLong(sb.toString());
            if (digit >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (digit <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) digit;
        }
        return 0;
    }

    public static boolean isDigit(char c) {
        int d = c - '0';
        return d >= 0 && d <= 9;
    }
}
