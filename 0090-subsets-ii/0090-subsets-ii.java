class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    void backtrack(int[] nums, int i, List<Integer> cur, List<List<Integer>> ans) {
        if (i >= nums.length) {
            // Collections.sort(cur);
            if (!ans.contains(cur)) ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        backtrack(nums, i + 1, cur, ans);
        cur.removeLast();
        backtrack(nums, i+1, cur, ans);
    }
}