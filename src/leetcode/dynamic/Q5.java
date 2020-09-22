package leetcode.dynamic;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Q5 {
    class Solution {
        public String longestPalindrome(String s) {
            // 暴力搜索
            if (s == null || s.length() < 2) return s;
            char[] chars = s.toCharArray();
            int len = chars.length;
            int max = 1;
            int start = 0;
            for (int i = 0; i < len - 1; ++i) {
                for (int j = 1; j < len; ++j) {
                    if ((j - i + 1) > max && isPalindrome(chars, i, j)) {
                        max = (j - i + 1);
                        start = i;
                    }
                }
            }
            return s.substring(start, start + max);
        }

        public boolean isPalindrome(char[] chars, int start, int end) {
            while (start < end) {
                if (chars[start] != chars[end]) {
                    return false;
                }
                ++start;
                --end;
            }
            return true;
        }
    }
}
