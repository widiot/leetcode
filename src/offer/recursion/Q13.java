package offer.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 机器人的运动范围
 */
public class Q13 {
    public static void main(String[] args) {
        System.out.println(movingCount(3, 1, 0));
    }

    public static int movingCount(int m, int n, int k) {
        int[][] a = new int[m][n];
        func(a, 0, 0, k);
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                count += a[i][j];
            }
        }
        return count;
    }

    private static void func(int[][] a, int i, int j, int k) {
        if (a[i][j] == 1 || greater(i, j, k)) { // 走过不走
            return;
        }
        a[i][j] = 1;
        // if ((j - 1) >= 0) { // 左
        //     func(a, i, j - 1, k);
        // }
        if ((j + 1) < a[0].length && !greater(i, j + 1, k)) { // 右
            func(a, i, j + 1, k);
        }
        // if ((i - 1) >= 0) { // 上
        //     func(a, i - 1, j, k);
        // }
        if ((i + 1) < a.length && !greater(i + 1, j, k)) { // 下
            func(a, i + 1, j, k);
        }
    }

    private static boolean greater(int i, int j, int k) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(Integer.toString(i).split("")));
        list.addAll(Arrays.asList(Integer.toString(j).split("")));
        int count = 0;
        for (String s : list) {
            count += Integer.parseInt(s);
        }
        return count > k;
    }
}
