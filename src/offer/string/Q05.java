package offer.string;

/**
 * 替换空格
 */
public class Q05 {
    public static void main(String[] args) {
        String s = s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // 先算有多少空格
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (' ' == s.charAt(i)) {
                sum++;
            }
        }
        // 再分配恰好的空间，转移到char数组中
        char[] chars = new char[len + 2 * sum];
        char t;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (' ' == (t = s.charAt(i))) {
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';
            } else {
                chars[j++] = t;
            }
        }
        return new String(chars);
    }
}
