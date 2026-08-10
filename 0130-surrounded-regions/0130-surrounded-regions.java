class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        List<Pair<Integer, Integer>> list = new ArrayList<>();

        Queue<Pair <Integer, Integer>> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n-1 || j == 0 || j == m - 1) && board[i][j] == 'O') {
                    vis[i][j] = true;
                    list.add ( new Pair<>(i, j) );
                    q.add (new Pair<> (i, j));
                }
            }
        }

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
                    list.add(new Pair<>(curI + 1, curJ));
                    q.add (new Pair<>(curI + 1, curJ));
                }

                if (curJ + 1 < m &&
                    board[curI][curJ + 1] == 'O' &&
                    !vis[curI][curJ + 1]
                ){
                    vis[curI][curJ + 1] = true;
                    list.add(new Pair<>(curI, curJ + 1));
                    q.add (new Pair<>(curI, curJ + 1));
                }

                if (curI - 1 >= 0 &&
                    board[curI - 1][curJ] == 'O' &&
                    !vis[curI - 1][curJ]
                ){
                    vis[curI - 1][curJ] = true;
                    list.add(new Pair<>(curI - 1, curJ));
                    q.add (new Pair<>(curI - 1, curJ));
                }

                if (curJ - 1 >= 0 &&
                    board[curI][curJ - 1] == 'O' &&
                    !vis[curI][curJ - 1]
                ){
                    vis[curI][curJ - 1] = true;
                    list.add(new Pair<>(curI, curJ - 1));
                    q.add (new Pair<>(curI, curJ - 1));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = 'X';
            }
        }

        for (Pair<Integer, Integer> x: list) {
            board[x.getKey()][x.getValue()] = 'O';
        }

        return;
    }
}