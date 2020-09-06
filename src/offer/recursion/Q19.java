package offer.recursion;

/**
 * 正则表达式匹配
 */
public class Q19 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "a*")); // true
        System.out.println(isMatch("ab", ".*")); // true
        System.out.println(isMatch("aab", "c*a*b")); // true
        System.out.println(isMatch("mississippi", "mis*is*p*.")); // false
        System.out.println(isMatch("aaaabbbb", ".*a.*b")); // true
        System.out.println(isMatch("aaa", "a*a")); // true
        System.out.println(isMatch("ab", ".*a")); // false
        System.out.println(isMatch("a", ".*..a*")); // false
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, 0, p, 0);
    }

    public static boolean isMatch(String s, int i, String p, int j) {
        int sLen = s.length(), pLen = p.length();
        if (i >= sLen && j >= pLen) {
            return true;
        }
        if (i < sLen && j >= pLen) {
            return false;
        }

        if (j < pLen - 1 && p.charAt(j + 1) == '*') {
            if (i < sLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                return isMatch(s, i, p, j + 2) ||
                        isMatch(s, i + 1, p, j + 2) ||
                        isMatch(s, i + 1, p, j);
            } else {
                return isMatch(s, i, p, j + 2);
            }
        }

        if (i < sLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            return isMatch(s, i + 1, p, j + 1);
        }

        return false;
    }

//    public static boolean isMatch(String s, String p) {
//        if (s == null || p == null) {
//            return false;
//        }
//        return isMatch(s, 0, p, 0);
//    }
//
//    public static boolean isMatch(String s, int i, String p, int j) {
//        if (s.length() <= i && p.length() <= j) {
//            return true;
//        } else if (s.length() <= i || p.length() <= j) {
//            return false;
//        }
//
//        // 当前字符和模式匹配，模式有如下三种情况
//        // - 如果是同一个字符
//        // ---- 模式的下一个字符是*号，则按0个，1个，多个这样去循环匹配
//        // ---- 模式的下一个字符是其他，则直接向后递归
//        // - 如果不是同一个字符
//        // ---- 模式的当前两个字符是.*号，循环将s与匹配.*后面的字符进行匹配
//        // ---- 模式的当前字符是.号，递归
//        // ---- 模式的下一个字符是*号，则向后递归
//        // ---- 模式的当前字符是其他字符，返回false
//        if (s.charAt(i) == p.charAt(j)) {
//            if (j != p.length() - 1) {
//                if (p.charAt(j + 1) == '*') {
//                    j += 2;
//                    while (i <= s.length() - 1 && j <= p.length() - 1 && s.charAt(i) == p.charAt(j)) {
//                        if (isMatch(s, i++, p, j)) {
//                            return true;
//                        }
//                    }
//                    return isMatch(s, i + 1, p, j);
//                }
//            }
//            return isMatch(s, i + 1, p, j + 1);
//        } else {
//            if ((j <= p.length() - 2) && p.charAt(j) == '.' && p.charAt(j + 1) == '*') {
//                if (j != p.length() - 2) {
//                    j += 2;
//                    if (j == p.length()) {
//                        return true;
//                    } else {
//                        while (i <= s.length()) {
//                            if (isMatch(s, i++, p, j)) {
//                                return true;
//                            }
//                        }
//                        return false;
//                    }
//                } else {
//                    return true;
//                }
//            }
//            if (p.charAt(j) == '.') {
//                return isMatch(s, i + 1, p, j + 1);
//            }
//            if ((j != p.length() - 1) && p.charAt(j + 1) == '*') {
//                return isMatch(s, i + 1, p, j + 2);
//            }
//        }
//        return false;
//    }
}
