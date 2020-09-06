package offer.array;

/**
 * 矩阵中的路径
 */
public class Q12 {
    public static void main(String[] args) {
        char[][] a = new char[][]{
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        System.out.println("a " + exist(a, "bfce"));
        System.out.println("a " + exist(a, "cese"));
        System.out.println("a " + exist(a, "afee"));

        char[][] a1 = new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        };
        System.out.println("a1 " + exist(a1, "abcd"));
        System.out.println("a1 " + exist(a1, "acdb"));

        char[][] a2 = new char[][]{
                {'a'}
        };
        System.out.println("a2 " + exist(a1, "a"));

        char[][] a3 = new char[][]{
                {'a', 'b'}
        };
        System.out.println("a3 " + exist(a1, "ba"));
    }

    public static boolean exist(char[][] board, String word) {
        // 每次以矩阵的一个点为起点，开始回溯路径

        if (word == null || word.length() == 0) {
            return false;
        }

        char[] chars = word.toCharArray();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == chars[0] && hasPath1(board, i, j, chars, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasPath(char[][] board, int row, int col, char[] chars, int index) {
        if (row < 0 ||
                col < 0 ||
                row >= board.length ||
                col >= board[0].length ||
                board[row][col] != chars[index]) {
            return false;
        }
        if (index == chars.length - 1) {
            return true;
        }

        char t = board[row][col];
        board[row][col] = '/';

        boolean hasPath = hasPath(board, row - 1, col, chars, ++index) ||
                hasPath(board, row, col + 1, chars, index) ||
                hasPath(board, row + 1, col, chars, index) ||
                hasPath(board, row, col - 1, chars, index);

        board[row][col] = t;

        return hasPath;
    }

    /**
     * 时间一样
     */
    public static boolean hasPath1(char[][] board, int row, int col, char[] chars, int index) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != chars[index]) {
            return false;
        }

        if (index == chars.length - 1) {
            return true;
        }

        char t = board[row][col];
        board[row][col] = '/';

        boolean hasPath = false;
        ++index;
        if ((row - 1) >= 0) {
            hasPath = hasPath1(board, row - 1, col, chars, index);
        }
        if (!hasPath && (col + 1) < board[0].length) {
            hasPath = hasPath1(board, row, col + 1, chars, index);
        }
        if (!hasPath && (row + 1) < board.length) {
            hasPath = hasPath1(board, row + 1, col, chars, index);
        }
        if (!hasPath && (col - 1) >= 0) {
            hasPath = hasPath1(board, row, col - 1, chars, index);
        }

        board[row][col] = t;

        return hasPath;
    }
}
