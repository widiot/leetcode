package offer.string;

/**
 * 最长不含重复字符的子字符串
 */
public class Q48 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("askdghjoasidugyoasujd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 滑动窗口，记录窗口最大长度

        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }

        char[] chars = s.toCharArray();

        int left = 0, right = 0;
        int max = 1;

        // 下一个数，和窗口中的每个值进行比较，如果相等就把left置为左边不等的索引
        int p;
        for (int i = 1; i < len; ++i) {
            p = left;
            while (p <= right) {
                if (chars[p] == chars[i]) {
                    left = p + 1;
                }
                ++p;
            }
            ++right;
            if ((p = (right - left + 1)) > max) {
                max = p;
            }
            if ((p + len - i) < max) {
                break;
            }
        }

        return max;
    }
}
