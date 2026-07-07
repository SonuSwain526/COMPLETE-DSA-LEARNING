import java.util.*;

class Solution {

    List<Integer>[] graph;

    public double frogPosition(int n, int[][] edges, int t, int target) {

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return dfs(1, -1, t, target, 1.0);
    }

    private double dfs(int node, int parent, int t, int target, double prob) {

        int children = 0;

        for (int next : graph[node]) {
            if (next != parent)
                children++;
        }

        // Reached target
        if (node == target) {

            if (t == 0 || children == 0)
                return prob;

            return 0.0;
        }

        if (t == 0)
            return 0.0;

        for (int next : graph[node]) {

            if (next == parent)
                continue;

            double ans = dfs(next, node, t - 1, target, prob / children);

            if (ans > 0)
                return ans;
        }

        return 0.0;
    }
}