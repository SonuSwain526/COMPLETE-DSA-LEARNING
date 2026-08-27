class Solution {
    class DSU{
        int[] size;
        int[] p;

        DSU(int n) {
            size = new int[n + 1];
            p = new int[n + 1];
            Arrays.fill(size, 1);
            for (int i = 0; i < n + 1; i++) p[i] = i;
        }

        int findP(int u) {
            if (u == p[u]) return u; 
            return p[u] = findP(p[u]);
        }

        boolean union(int u, int v) {
            int pu = findP(u);
            int pv = findP(v);

            if (pu == pv) return false;
            if (size[pu] > size[pv]) {
                p[pv] = pu;
                size[pu] += size[pv];
            }else {
                p[pu] = pv;
                size[pv] += size[pu];
            }
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> map = new HashMap<>();

        int n = accounts.size();
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (map.getOrDefault(accounts.get(i).get(j), -1) == -1) {
                    map.put(accounts.get(i).get(j), i);
                }else {
                    dsu.union(i, map.get(accounts.get(i).get(j)));
                }
            }
        }

        List<List<String>> x = new ArrayList<>();

        for (int i = 0; i < n; i++) x.add(new ArrayList<>());

        for (Map.Entry<String, Integer> cur: map.entrySet()) {
            String str = cur.getKey();
            int ix = dsu.findP(cur.getValue());

            x.get(ix).add(str);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (x.get(i).size() == 0) continue;
            Collections.sort(x.get(i));
            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(i).get(0));

            for (String c: x.get(i)) {
                temp.add(c);
            }
            ans.add(temp);
        }
        return ans;
    }
}


