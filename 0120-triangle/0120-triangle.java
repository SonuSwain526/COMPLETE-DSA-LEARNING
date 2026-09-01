class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        List<List<Integer>> dp = new ArrayList<>();

        for (List<Integer> row : t) {
            dp.add(new ArrayList<>(Collections.nCopies(row.size(), Integer.MAX_VALUE)));
        }
        return f(t, 0, 0, dp);
    }
    int f(List<List<Integer>> t, int i, int j, List<List<Integer>> dp) {
        if (i >= t.size()) return Integer.MAX_VALUE;
        if (i == t.size() - 1) return t.get(i).get(j);
        if (dp.get(i).get(j) != Integer.MAX_VALUE) return dp.get(i).get(j);
        dp.get(i).set(j, t.get(i).get(j) +
                Math.min(f(t, i + 1, j, dp),
                        f(t, i + 1, j + 1, dp)));

        return dp.get(i).get(j);
    }
}