import java.util.*;

class UnionFind {
    int[] parent;
    int[] size;

    UnionFind(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = findParent(parent[x]);
    }

    boolean union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv)
            return false;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }

        return true;
    }
}

class Solution {

    int kruskal(int n, int[][] edges, int skip, int force) {

        UnionFind uf = new UnionFind(n);

        int weight = 0;
        int count = 0;

        // Force this edge first
        if (force != -1) {

            int[] e = edges[force];

            int u = e[0];
            int v = e[1];
            int wt = e[2];

            uf.union(u, v);

            weight += wt;
            count++;
        }

        // Normal Kruskal
        for (int i = 0; i < edges.length; i++) {

            if (i == skip || i == force)
                continue;

            int[] e = edges[i];

            int u = e[0];
            int v = e[1];
            int wt = e[2];

            if (uf.union(u, v)) {

                weight += wt;
                count++;

                if (count == n - 1)
                    break;
            }
        }

        // Couldn't connect all vertices
        if (count != n - 1)
            return Integer.MAX_VALUE;

        return weight;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(
            int n, int[][] edges) {

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        // Add original index
        for (int i = 0; i < edges.length; i++) {

            edges[i] = Arrays.copyOf(edges[i], 4);

            edges[i][3] = i;
        }

        // Sort by weight
        Arrays.sort(
            edges,
            (a, b) -> Integer.compare(a[2], b[2])
        );

        // Normal MST
        int originalMST = kruskal(n, edges, -1, -1);

        for (int i = 0; i < edges.length; i++) {

            // Check critical
            int withoutEdge = kruskal(n, edges, i, -1);

            if (withoutEdge > originalMST) {

                critical.add(edges[i][3]);

            } else {

                // Check pseudo-critical
                int withEdge = kruskal(n, edges, -1, i);

                if (withEdge == originalMST) {
                    pseudoCritical.add(edges[i][3]);
                }
            }
        }

        return Arrays.asList(critical, pseudoCritical);
    }
}