class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if (edges.length == 0) {
            ans.add(0);
            return ans;
        }
        List<List<Integer>> gp = new ArrayList<>();
        
        for (int i = 0; i < n; i++) gp.add(new ArrayList<>());

        int[] indeg = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < edges.length; i++) {
            gp.get(edges[i][0]).add(edges[i][1]);
            indeg[edges[i][0]]++;
            gp.get(edges[i][1]).add(edges[i][0]);
            indeg[edges[i][1]]++;
        }

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 1) q.add(i);
        }

        int remaining = n;

        while (remaining > 2) {
            int size = q.size();
            remaining -= size;
            for (int i = 0; i < size; i++){
                int cur = q.poll();

                for (int ng: gp.get(cur)) {
                    if (--indeg[ng] == 1) {
                        q.add(ng);
                    }
                }
            }
            // if (size)
        }

        while (!q.isEmpty()) ans.add(q.poll());
        return ans;

        // int last = -1;


        // for (int i = 0; i < n; i++) {
        //     if (indeg[i] != 0){
        //         boolean[] vis = new boolean[n];
        //         int cur = bfs(gp, i, vis);
        //         if (last != -1) {
        //             if (last == cur) ans.add(i);
        //             if (last > cur) {
        //                 ans = new ArrayList<>();
        //                 ans.add(i);
        //                 last = cur;
        //             }
        //         }else if(last == -1) {
        //             ans.add(i);
        //             last = cur;
        //         }
        //     }
        // }

        // return ans;
    }

    int bfs(List<List<Integer>> gp, int st, boolean[] vis) {
        int level = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        vis[st] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
            int cur = q.poll();
            // boolean b = false;
                for (int x: gp.get(cur)) {
                    if (!vis[x]) {
                        vis[x] = true;
                        q.add(x);
                        // b = true;
                    }
                }
            }
            level++;
        }
    return level;
    }
}