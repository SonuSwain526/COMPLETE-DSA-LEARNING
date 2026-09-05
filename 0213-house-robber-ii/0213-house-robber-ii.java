class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n - 1];
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n -1; i++) {
            int take = nums[i] + dp[i - 2];
            int skip = dp[i-1];
            dp[i] = Math.max(take, skip);
        }
        int ans = dp[n - 2];
        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            int take = nums[i] + dp[i - 1 - 2];
            int skip = dp[i-2];
            dp[i-1] = Math.max(take, skip);
        }
        return Math.max(ans, dp[n-2]);
    }
}