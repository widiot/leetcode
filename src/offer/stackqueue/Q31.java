package offer.stackqueue;

/**
 * 栈的压入、弹出序列
 */
public class Q31 {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        int len = pushed.length;
        int l = 1, r = 0;
        int top;
        while (r < len) {
            top = l - 1;
            while (top > 0 && pushed[top] == -1) {
                top--;
            }
            if (pushed[top] == popped[r]) {
                pushed[top] = -1;
                r++;
                continue;
            } else if (l == len) {
                return false;
            }
            if (l < len) {
                l++;
            }
        }
        return true;
    }
}
