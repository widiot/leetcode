package offer.string;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 翻转字符串
 */
public class Q58 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));

        System.out.println(reverseWords1("the sky is blue"));
        System.out.println(reverseWords1("  hello world!  "));
        System.out.println(reverseWords1("a good   example"));
        System.out.println(reverseWords1("     "));
        System.out.println(reverseWords1("a"));
        System.out.println(reverseWords1("ab"));
    }

    public static String reverseWords1(String s) {
        // 双指针，找单词，然后将单词放在前置位

        int len;
        if (s == null || (len = s.length()) == 0) {
            return "";
        }

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        int i = len - 1, j = i;
        while (i >= 0) {
            while (j > 0 && chars[j] == ' ') {
                --j;
            }
            i = j;
            while (i > 0 && chars[i] != ' ' && chars[i - 1] != ' ') {
                --i;
            }
            if (chars[j] != ' ') {
                sb.append(Arrays.copyOfRange(chars, i, j + 1));
                sb.append(' ');
                j = i - 1;
            }
            if (j <= 0) {
                break;
            }
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        String[] strsTemp = new String[strs.length];
        for (int i = 0; i < strs.length; ++i) {
            if (!"".equals(strs[i])) {
                strsTemp[i] = reverse(strs[i]);
            }
        }
        String sTemp = Arrays.stream(strsTemp).filter(Objects::nonNull).collect(Collectors.joining(" "));
        return reverse(sTemp);
    }

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; ++i) {
            char t = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = t;
        }
        return new String(chars);
    }
}
