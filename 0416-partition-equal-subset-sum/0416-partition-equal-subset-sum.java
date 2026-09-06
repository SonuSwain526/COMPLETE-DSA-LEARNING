class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x: nums) sum += x;

        if (sum % 2 != 0) return false;

        int t = sum / 2;

        boolean[][] dp = new boolean[nums.length][t + 1];

        for (int i = 0; i < dp.length; i++) dp[i][0] = true;
        if (nums[0] < t + 1) dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < sum / 2 + 1; j++) {
                boolean take = dp[i-1][j];
                boolean skip = false;
                if (nums[i] <= j) skip = dp[i - 1][j - nums[i]];
                dp[i][j] = take || skip;
            }
        }

        return dp[dp.length - 1][t];
    }

    boolean f(int[] nums, int tar, int[][] dp, int ix) {
        if (tar == 0) return true;
        if (tar < 0 || ix >= nums.length) return false;
        if (dp[ix][tar] != -1) return dp[ix][tar] == 1 ? true : false;

        boolean b = f(nums, tar - nums[ix], dp, ix + 1) || f(nums, tar, dp, ix + 1);
        if (b) dp[ix][tar] = 1;
        else dp[ix][tar] = 0;
        return b;
    }
}