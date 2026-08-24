class Solution {
    int[] size;
    int[] p;

    void init (int n) {
        size = new int[n];
        p = new int[n];

        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) p[i] = i;
    }
    int findP (int u) {
        if (u == p[u]) return u;
        return p[u] = findP(p[u]);
    }

    boolean add (int u, int v) {
        int pu = findP(u);
        int pv = findP(v);

        if (pu == pv) return true;
        if (size[pu] > size[pv]) {
            p[pv] = pu;
            size[pu] = size[pu] + size[pv];
        }else {
            p[pu] = pv;
            size[pv] = size[pu] + size[pv];
        }
        return false;
    }
    public int makeConnected(int n, int[][] connections) {
        init(n);
        int c = 0;
        int el = n;
        for (int[] cur: connections) {
            if (add(cur[0], cur[1])) c++;
            else el--;
        }
        if (c >= el-1) return el - 1;
        return -1;
    }
}