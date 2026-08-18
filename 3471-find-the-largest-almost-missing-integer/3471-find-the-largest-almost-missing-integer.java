class Solution {
    public int largestInteger(int[] nums, int k) {
        int ans = -1; 
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int x: nums) map.put(x, map.getOrDefault(x, 0) + 1);

        // if (nums[0] == nums[n-1]) return -1;
        if (k == 1 || k == n) {
            if (k == 1) {
                for (int x: nums){ 
                    if (map.get(x) == 1) ans = Math.max(ans, x);
                }
                return ans;
            }
            for (int x: nums) ans = Math.max(ans, x);
            return ans;
        }

        // for (int i = 0; i < n; i++) {
        //     if (n - i - 1 < k || i == 0) {ans = Math.max(1, ans); continue;}
        //     int prev = Math.min(i, k - 1);
        //     ans = Math.max(prev + 1, ans);
        // }
        // int c = 0; 
        // for (int i = 0; i < k; i++) {
        //     if (nums[i] == nums[0]) c++;
        // }
        // if (c == 1) ans = nums[0];
        // c = 0;
        // for (int i = n - k; i < n; i++) {
        //     if (nums[n - 1] == nums[i]) c++;
        // }
        // if (c == 1) ans = Math.max(ans, nums[n - 1]);

        if (map.get(nums[0]) == 1) ans = Math.max(ans, nums[0]);
        if (map.get(nums[n-1]) == 1) ans = Math.max(ans, nums[n - 1]);

        return ans;
    }
}