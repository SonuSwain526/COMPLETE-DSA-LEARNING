class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add (new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        return dfs (source, destination, new boolean[n], graph);

    }

    boolean dfs (int src, int des, boolean[] vis, List<List<Integer>> graph) {

        if (src == des) return true;
        if (vis[src]) return false;

        vis[src] = true;

        for (int connectedVer: graph.get(src)) {
            if (!vis[connectedVer] && dfs (connectedVer, des, vis, graph)) return true;
        }

        return false;
    }
}