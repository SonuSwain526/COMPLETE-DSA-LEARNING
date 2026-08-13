class Solution {
    public boolean isBipartite(int[][] graph) {
        // List<List<Integer>> gp = new ArrayList
        int n = graph.length;

        // boolean[] vis = new boolean[n];

        int[] color = new int[n];

         Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;

             color[i] = 1;
            
             q.add(i);

             while (!q.isEmpty()) {
                int size = q.size();

                while (size-- > 0) {
                    int curC = q.poll();
                    for (int cur: graph[curC]) {
                        if (color[cur] == 0) {
                            color[cur] = 3 - color[curC];
                            q.add(cur);
                        }else {
                            if (color[cur] == color[curC]) return false;
                        }
                    }
                }
             }
        }
        return true;
        // List<Integer> a = new ArrayList<>();
        // List<Integer> b = new ArrayList<>();

       
        // q.add(new Pair<>(0, 0));
        // vis[0] = true;
        // a.add(0);

        // while (!q.isEmpty()) {
        //     int size = q.size();

        //     while (size-- > 0) {
        //         Pair<Integer, Integer> p = q.poll();
        //         int level = p.getKey() + 1;
        //         for (int cur: graph[p.getValue()]) {
        //             if (!vis[cur]) {
        //                 if (level % 2 == 0) {
        //                     vis[cur] = true;
        //                     if (b.contains(cur)) return false;
        //                     if (!a.contains(cur)) a.add(cur);
        //                 }else {
        //                     vis[cur] = true;
        //                     if (a.contains(cur)) return false;
        //                     if (!b.contains(cur)) b.add(cur);
        //                 }
        //                 q.add(new Pair<>(cur, level));
        //             }else {
        //                 if (level % 2 == 0) {
        //                     if (!a.contains(cur)) return false;
        //                 }else if (level % 2 != 0 && !b.contains(cur)) return false;
        //             }
        //         }
        //     }
        // }

        // return true;
    }
}