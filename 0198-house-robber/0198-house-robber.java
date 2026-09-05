class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (dp.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int take = nums[i] + dp[i - 2];
            int skip = dp[i-1];
            dp[i] = Math.max(take, skip);
        }
        // Arrays.fill(dp, -1);

        // return dph(nums, 0, dp);
        return dp[nums.length - 1];
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