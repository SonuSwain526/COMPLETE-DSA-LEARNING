class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] nextmin = new int[n];
        nextmin[n-1] = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            nextmin[i] = Math.min(nextmin[i + 1], nums[i]);
        }
        int max = 0;
        int ans = -1;
        int x = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            int cur = max - nextmin[i];

            if (cur <= k ){
                return i;
                // x = cur;
                // ans = i;
            }
        }
        return ans;
    }
}