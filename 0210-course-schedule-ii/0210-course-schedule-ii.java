class Solution {
    public int[] findOrder(int numCourses, int[][] p) {
        List<List<Integer>> gp = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) gp.add(new ArrayList<>());

        int[] inDeg = new int[numCourses];

        for (int i = 0; i < p.length; i++) {
            gp.get(p[i][1]).add(p[i][0]);
            inDeg[p[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) q.add(i);
        }

        int[] ans = new int[numCourses];
        int j = 0; 

        while (!q.isEmpty() && j < numCourses) {
            int cur = q.poll();
            ans[j++] = cur;

            for (int ng: gp.get(cur)) {
                if (--inDeg[ng] == 0) {
                    q.add(ng);
                }
            }
        }
        // System.out.println(Arrays.toString(ans));
        if (j == numCourses) return ans;
        return new int[]{};
    }
}