package offer.string;

/**
 * 左旋转字符串
 */
public class Q58Q2 {
    public static void main(String[] args) {
        String s = "ab";
        System.out.println(reverseLeftWords(s, 2));
    }

    /**
     * 自研：时间复杂度O(n)，空间复杂度O(n)
     * 使用一个辅助空间，将原始字符串的第n个字符后面的数字先放在辅助空间前面，再利用循环i把前n个字符放到后面
     */
    public static String reverseLeftWords(String s, int n) {
        if (s == null || s.length() <= 1 || n < 1 || n > s.length()) {
            return s;
        }
        char[] sc = new char[s.length()];
        for (int i = n; i < s.length() + n; i++) {
            sc[i - n] = s.charAt(i % s.length());
        }
        return new String(sc);
    }

    /**
     * 剑指Offer解法：将字符串按区旋转两次
     */
    public static String reverseLeftWordsStandard(String s, int n) {
        if (s == null || s.length() <= 1 || n < 1 || n > s.length()) {
            return s;
        }
        return null;
    }
}
