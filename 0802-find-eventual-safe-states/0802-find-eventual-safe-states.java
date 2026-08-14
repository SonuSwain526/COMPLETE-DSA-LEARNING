class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> gp = new ArrayList<>();

        for (int i = 0; i < n; i++) gp.add(new ArrayList<>());
        
        int x = 0;
        for (int[] cur: graph) {
            for (int el: cur) {
                gp.get(el).add(x);
            }
            x++;
        }

        int[] outdeg = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            outdeg[i] = graph[i].length;
            if (outdeg[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            int el = q.poll();
            list.add(el);

            for (int cur: gp.get(el)) {
                if (--outdeg[cur] == 0) {
                    q.add(cur);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}