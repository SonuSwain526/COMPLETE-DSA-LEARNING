class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(0, nums, ans, new ArrayList<>());
        return ans;
        
    }
    int helper(int i, int[] nums, List<List<Integer>> ans, List<Integer> cur) {

        if (cur.size() >= nums.length) {
            if (cur.size() == nums.length && !ans.contains(cur)) {
                ans.add(new ArrayList<>(cur));
            }
            return i;
        }

        
        for (int ix = 0; ix < nums.length; ix++) {
            if (cur.contains(nums[ix])) continue;

            cur.add(nums[ix]);
            helper(ix, nums, ans, cur);
            cur.removeLast();
        }
        
        return i;
    }
}