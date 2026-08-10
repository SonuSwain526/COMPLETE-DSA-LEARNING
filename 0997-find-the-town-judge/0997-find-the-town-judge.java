class Solution {
    public int findJudge(int n, int[][] trust) {
        
        // List<List<Integer>> gp = new ArrayList<>();

        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        // for (int i = 0; i <= n; i++) {
        //     gp.add (new ArrayList<>());
        // }
        for (int[] t : trust) {
            outdegree[t[0]]++;
            indegree[t[1]]++;
        }
        // for (int i = 0; i < trust.length; i++) {
        //     gp.get(trust[i][0]).add(trust[i][1]);
        // }
        // boolean ans = false;
        // int x = 0;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    boolean dfs (int src, int g, List<List<Integer>> gp, boolean[] vis) {

        if (vis[src]) return false;
        if (src == g) return true;

        vis[src] = true;

        for (int trusters: gp.get(src)) {
            if (!vis[trusters] && dfs (trusters, g, gp, vis)) return true;
        }

        return false;
    }
}