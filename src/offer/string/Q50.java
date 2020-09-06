package offer.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 */
public class Q50 {
    public static void main(String[] args) {
        String s = "ab";
        System.out.println(firstUniqChar(s));
    }

    /**
     * 自研：用map记录每个字符出现的次数，按顺序查询第一个仅出现一次的字符
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    public static char firstUniqChar(String s) {
        if (s == null) {
            return ' ';
        }
        if (s.length() == 1) {
            return s.charAt(0);
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(c = s.charAt(i))) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return ' ';
    }
}
