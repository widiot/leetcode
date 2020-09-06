package offer.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 字符串的排列
 */
public class Q38 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abc")));
    }

    public static String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        swap(s.toCharArray(), 0, set);
        return set.toArray(new String[0]);
    }

    public static void swap(char[] chars, int i, Set<String> set) {
        for (int j = i; j < chars.length; ++j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            set.add(new String(chars));

            swap(chars, i + 1, set);

            t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
        }
    }
}
