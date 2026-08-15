class Solution {
    public List<String> findAllRecipes(String[] r, List<List<String>> ing, String[] s) {
        int n = r.length;

        List<String> sup = new ArrayList<>();
        for (String cur: s) sup.add(cur);

        Map<String, List<String>> gp = new HashMap<>();

        Map<String, Integer> indeg = new HashMap<>();

        for (String ss: r) {
            gp.put(ss, new ArrayList<>());
            indeg.put(ss, 0);
        }
        for (String ss: s) {
            gp.put(ss, new ArrayList<>());
            indeg.put(ss, 0);
        }

        List<String> set = new ArrayList<>();

        for (String rec: r) if(!set.contains(rec)) set.add(rec);

        for (int i = 0; i < n; i++) {
            for(String ss: ing.get(i)) {
                List<String> x = gp.getOrDefault(ss, new ArrayList<>());
                x.add(r[i]);
                gp.put(ss, x);
                indeg.put(r[i], indeg.getOrDefault(r[i], 0) + 1);
                if(!set.contains(ss)) set.add(ss);
            }
        }

        Queue<String> q = new LinkedList<>();
        for (String cur: set) {
            if (indeg.get(cur) != null && indeg.get(cur) == 0) {
                q.add(cur);
            }
        }

        List<String> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (!sup.contains(cur)) ans.add(cur);

            for (String ingg: gp.get(cur)) {
                indeg.put(ingg, indeg.get(ingg) - 1);
                if (indeg.get(ingg) == 0) q.add(ingg);
            }
        }

        return ans;
    }
}