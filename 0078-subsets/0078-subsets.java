class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans, new ArrayList<>());
        return ans;
    }
    int helper(int[] nums, int i, List<List<Integer>> x, List<Integer> cur) {

        if (i >= nums.length) {
            if (!x.contains(cur)) {
                x.add(new ArrayList<>(cur));
            }
            return i;
        }

        cur.add(nums[i]);
        helper(nums, i+1, x, cur);
        cur.removeLast();
        helper(nums, i+1, x, cur);
        return i;
    }
}