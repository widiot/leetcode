package offer.array;

/**
 * 二维数组的查找
 */
public class Q4 {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(a, 5));
        System.out.println(findNumberIn2DArray(a, 20));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows, cols;
        if ((rows = matrix.length) == 0 || (cols = matrix[0].length) == 0) {
            return false;
        }

        int i = rows - 1, j = 0;
        int t;
        while (i >= 0 && j < cols) {
            t = matrix[i][j];
            if (t < target) {
                ++j;
            } else if (t > target) {
                --i;
            } else {
                return true;
            }
        }

        return false;
    }
}
