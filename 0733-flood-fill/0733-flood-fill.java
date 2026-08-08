class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        boolean[][] vis = new boolean[n][m];

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int old = image[sr][sc];
        if (old == color) return image;

        image[sr][sc] = color;
        vis[sr][sc] = true;
        q.add(new Pair<>(sr, sc));

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = q.poll();
                int curI = cur.getKey();
                int curJ = cur.getValue();

                if (curI + 1 < n && image[curI + 1][curJ] == old && !vis[curI + 1][curJ]) {
                    vis[curI + 1][curJ] = true;
                    image[curI + 1][curJ] = color;
                    q.add (new Pair<> (curI + 1, curJ));
                }
                if (curJ + 1 < m && image[curI][curJ + 1] == old && !vis[curI][curJ + 1]) {
                    vis[curI][curJ + 1] = true;
                    image[curI][curJ + 1] = color;
                    q.add (new Pair<> (curI, curJ + 1));
                }
                if (curI - 1 >= 0 && image[curI - 1][curJ] == old && !vis[curI - 1][curJ]) {
                    vis[curI - 1][curJ] = true;
                    image[curI - 1][curJ] = color;
                    q.add (new Pair<> (curI - 1, curJ));
                }
                if (curJ - 1 >= 0 && image[curI][curJ - 1] == old && !vis[curI][curJ - 1]) {
                    vis[curI][curJ - 1] = true;
                    image[curI][curJ - 1] = color;
                    q.add (new Pair<> (curI, curJ - 1));
                }
            }
        }
        return image;
    }
}