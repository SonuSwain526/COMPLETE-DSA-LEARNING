class Solution {
    public void solve(char[][] board) {
        int n = board.length;      // rows
        int m = board[0].length;   // columns

        boolean[][] vis = new boolean[n][m];

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        // Left and right columns
        for (int i = 0; i < n; i++) {

            // Left column
            if (board[i][0] == 'O') {
                vis[i][0] = true;
                q.add(new Pair<>(i, 0));
            }

            // Right column
            if (board[i][m - 1] == 'O') {
                vis[i][m - 1] = true;
                q.add(new Pair<>(i, m - 1));
            }
        }

        // Top and bottom rows
        for (int j = 0; j < m; j++) {

            // Top row
            if (board[0][j] == 'O') {
                vis[0][j] = true;
                q.add(new Pair<>(0, j));
            }

            // Bottom row
            if (board[n - 1][j] == 'O') {
                vis[n - 1][j] = true;
                q.add(new Pair<>(n - 1, j));
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if ((i == 0 || i == n-1 || j == 0 || j == m - 1) && board[i][j] == 'O') {
        //             vis[i][j] = true;
        //             // list.add ( new Pair<>(i, j) );
        //             q.add (new Pair<> (i, j));
        //         }
        //     }
        // }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                
                Pair <Integer, Integer> cur = q.poll();
                int curI = cur.getKey();
                int curJ = cur.getValue();

                if (curI + 1 < n &&
                    board[curI + 1][curJ] == 'O' &&
                    !vis[curI + 1][curJ]
                ){
                    vis[curI + 1][curJ] = true;
                    // list.add(new Pair<>(curI + 1, curJ));
                    q.add (new Pair<>(curI + 1, curJ));
                }

                if (curJ + 1 < m &&
                    board[curI][curJ + 1] == 'O' &&
                    !vis[curI][curJ + 1]
                ){
                    vis[curI][curJ + 1] = true;
                    // list.add(new Pair<>(curI, curJ + 1));
                    q.add (new Pair<>(curI, curJ + 1));
                }

                if (curI - 1 >= 0 &&
                    board[curI - 1][curJ] == 'O' &&
                    !vis[curI - 1][curJ]
                ){
                    vis[curI - 1][curJ] = true;
                    // list.add(new Pair<>(curI - 1, curJ));
                    q.add (new Pair<>(curI - 1, curJ));
                }

                if (curJ - 1 >= 0 &&
                    board[curI][curJ - 1] == 'O' &&
                    !vis[curI][curJ - 1]
                ){
                    vis[curI][curJ - 1] = true;
                    // list.add(new Pair<>(curI, curJ - 1));
                    q.add (new Pair<>(curI, curJ - 1));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) board[i][j] = 'X';
            }
        }

        // for (Pair<Integer, Integer> x: list) {
        //     board[x.getKey()][x.getValue()] = 'O';
        // }

        return;
    }
}