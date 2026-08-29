class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int[] c, int t, int sum, int i, List<Integer> cur, List<List<Integer>> ans) {

        if (sum >= t || i >= c.length) {
            if (sum == t) ans.add(new ArrayList<>(cur));
            return;
        }

        cur.add(c[i]);
        backtrack(c, t, sum + c[i], i, cur, ans);
        cur.removeLast();
        backtrack(c, t, sum, i + 1, cur, ans);
    }
}