class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            gp.add(new ArrayList<>());
        }
        int[] indeg = new int[numCourses];

        for (int i = 0; i < p.length; i++) {
            gp.get(p[i][1]).add(p[i][0]);
            indeg[p[i][0]]++;
        }


        Queue<Integer> q = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            // int curIndeg = gp.get(i).size();
            // indeg[i] = curIndeg;
            if (indeg[i] == 0) q.add(i);
        }
        if (q.isEmpty()) return false;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int nb: gp.get(cur)) {
                if (--indeg[nb] == 0) {
                    q.add(nb);
                }
            }
        }

        return count == numCourses;

    }
}