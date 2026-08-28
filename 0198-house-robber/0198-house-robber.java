class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return dph(nums, 0, dp);
    }

    int dph(int[] nums, int i, int[] dp) {
        if (i >= nums.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int take = nums[i] + dph(nums, i + 2, dp);
        int skip = dph(nums, i + 1, dp);

        return dp[i] = Math.max(take, skip);
    }
}