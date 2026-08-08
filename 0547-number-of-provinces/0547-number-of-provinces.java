class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        
        boolean[] vis = new boolean[n];

        int c = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                c++;
                vis[i] = true;
                dfs(i, isConnected, vis);
            }
        }

        return c;
    }

    void dfs (int node, int[][] isConnected, boolean[] vis) {

        int[] curArr = isConnected[node];
        for (int i = 0; i < curArr.length; i++) {
            if (!vis[i] && curArr[i] != 0) {
                vis[i] = true;
                dfs(i, isConnected, vis);
            }
        }

    }
}