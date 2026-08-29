class Solution {
    public boolean exist(char[][] board, String word) {
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] b = new boolean[m][n];
                    b[i][j] = true;
                    if (find(board, word, i, j, b, m, n, x, y, 1)) return true;
                }
            }
        }
        return false;
    }

    boolean find(char[][] c, String s, int i, int j, boolean[][] b, int m, int n, int[] x, int[] y, int cur) {
        if (cur >= s.length()) {
            return true;
        }


        for (int k = 0; k < 4; k++) {
            int inI = i + x[k];
            int inJ = j + y[k];

            if (inI >= 0 && inI < m && inJ >= 0 && inJ < n) {
                if (!b[inI][inJ] && c[inI][inJ] == s.charAt(cur)) {
                    b[inI][inJ] = true;
                    if (find(c, s, inI, inJ, b, m, n, x, y, cur + 1)) return true;
                    b[inI][inJ] = false;
                    // return curb;
                }
            }
        }
        return false;
    }
}