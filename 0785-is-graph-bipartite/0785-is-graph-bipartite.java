class Solution {

    public boolean isBipartite(int[][] graph) {

        int[] c = new int[graph.length];
        Arrays.fill(c, -1);
       
       Stack<Integer> st = new Stack<>();
       for (int i = 0; i < graph.length; i++) {
        if (c[i] != -1) continue;
        st.push(i);
        c[i] = 0;

        while (!st.isEmpty()) {
                int size = st.size();
                while (size-- > 0) {
                    int cur = st.pop();
                    for (int nb: graph[cur]) {
                        if (c[nb] != -1) {
                            if (c[nb] == c[cur]) return false;
                        }else {
                            c[nb] = Math.abs(c[cur] - 1);
                            st.push(nb);
                        }
                    }
                }
            }
       }

       return true;
    }


}