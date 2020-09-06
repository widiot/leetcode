package offer.recursion;

import java.util.Arrays;

/**
 * 礼物的最大价值
 */
public class Q47 {
    public static void main(String[] args) {
        int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue(array));
    }

    public static int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] max = new int[grid[0].length];
        Arrays.fill(max, 0);
        int up, left;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                up = 0;
                left = 0;
                if (i > 0) {
                    up = max[j];
                }
                if (j > 0) {
                    left = max[j - 1];
                }
                max[j] = Math.max(up, left) + grid[i][j];
            }
        }
        return max[max.length - 1];
    }
}
