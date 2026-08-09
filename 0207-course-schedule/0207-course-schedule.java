class Solution {
    public boolean canFinish(int numCourses, int[][] p) {

        int n = p.length;

        boolean[] vis = new boolean[numCourses];
        boolean[] onlyCompCheck = new boolean[numCourses];

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            List<Integer> x = graph.getOrDefault(p[i][0], new ArrayList<>());
            x.add(p[i][1]);
            graph.put(p[i][0], x);
        }

        for (int i = 0; i < numCourses; i++) {
            List<Integer> cur = graph.getOrDefault( i, new ArrayList<>());

            if (cur.size() != 0) {
                // vis[i] = true;
                if (isCycle (graph, i, vis, onlyCompCheck)) return false;
                vis = new boolean[numCourses];
            }
        }

        return true;
    }

    // boolean isScycle (HashMap<Integer, List<Integer>> map, int src, boolean[] vis, int tr) {
    //     boolean b = true;
    //     if (map.get(src) == null) return true;
    //     for (int x: map.get(src)) {
    //         if (vis[x] || x == tr) return false;
    //         vis[x] = true;
    //         b = isScycle (map, x, vis, tr);
    //         vis[x] = false;
    //     }
    //     return b;
    // }

    boolean isCycle(HashMap<Integer, List<Integer>> graph,
                    int src,
                    boolean[] pathVis,
                    boolean[] onlyCompCheck) {

        if (pathVis[src]) return true;  // came back to current path
        if (onlyCompCheck[src]) return false;
        onlyCompCheck[src] = true;
        pathVis[src] = true;

        for (int x : graph.getOrDefault(src, new ArrayList<>())) {
            if (isCycle(graph, x, pathVis, onlyCompCheck))
                return true;
        }

        pathVis[src] = false; // remove from current DFS path

        return false;
    }

}