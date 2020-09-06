package offer.array;

import java.util.Arrays;

/**
 * 顺时针打印矩阵
 */
public class Q29 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {8, 10, 11, 12}
        };
        int[][] arr1 = new int[][]{
                {1},
                {2}
        };
        int[][] arr2 = new int[][]{
                {1}
        };
        int[][] arr3 = new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {8, 10, 11}
        };
        int[][] arr4 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {8, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] arr5 = new int[][]{
                {2, 5},
                {8, 4},
                {0, -1}
        };
        int[][] arr6 = new int[][]{
                {2, 5},
                {8, 4}
        };
        int[][] arr7 = new int[][]{
                {2, 3}
        };
        int[][] arr8 = new int[][]{
                {7},
                {9},
                {6}
        };
        System.out.println(Arrays.toString(spiralOrder(arr)));
        System.out.println(Arrays.toString(spiralOrder(arr1)));
        System.out.println(Arrays.toString(spiralOrder(arr2)));
        System.out.println(Arrays.toString(spiralOrder(arr3)));
        System.out.println(Arrays.toString(spiralOrder(arr4)));
        System.out.println(Arrays.toString(spiralOrder(arr5)));
        System.out.println(Arrays.toString(spiralOrder(arr6)));
        System.out.println(Arrays.toString(spiralOrder(arr7)));
        System.out.println(Arrays.toString(spiralOrder(arr8)));
    }

    public static int[] spiralOrder(int[][] matrix) {
        // 依次打印上右下左四条边

        int rows, cols;
        if ((rows = matrix.length) == 0 || (cols = matrix[0].length) == 0) {
            return new int[0];
        }

        int[] nums = new int[rows * cols];

        int n = 0;
        int rounds = (Math.min(rows, cols) + 1) >> 1;
        int t;
        for (int i = 0; i < rounds; ++i) {
            t = i + 1;
            for (int top = i; top < (cols - i); ++top) {
                nums[n++] = matrix[i][top];
            }
            for (int right = t; right < (rows - i); ++right) {
                nums[n++] = matrix[right][cols - t];
            }
            if (t << 1 <= rows) {
                for (int bottom = (cols - i - 2); bottom >= i; --bottom) {
                    nums[n++] = matrix[rows - t][bottom];
                }
            }
            if (t << 1 <= cols) {
                for (int left = (rows - i - 2); left > i; --left) {
                    nums[n++] = matrix[left][i];
                }
            }
        }

        return nums;
    }
}
