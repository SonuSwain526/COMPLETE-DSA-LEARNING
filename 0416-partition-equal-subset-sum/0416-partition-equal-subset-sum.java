class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x: nums) sum += x;

        if (sum % 2 != 0) return false;

        int[][] dp = new int[nums.length][sum / 2 + 1];
        for (int[] x: dp) Arrays.fill(x, -1);

        return f(nums, sum / 2, dp, 0);
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