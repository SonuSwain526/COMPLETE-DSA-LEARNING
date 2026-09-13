class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> dp = new HashMap<>();
        return f(nums, target,nums.length - 1, dp);
    }
    int f(int[] nums, int t, int i, HashMap<String, Integer> map) {
        if (i == 0) {
            if (nums[i] == 0 && t == 0) return 2;
            if (t + nums[i] == 0 || t - nums[i] == 0) return 1;
            return 0;
        }

        String cur = i + "." + t;

        if (map.containsKey(cur)) 
            return map.get(cur);

        int pos = f(nums, t + nums[i], i - 1, map);
        int neg = f(nums, t - nums[i], i - 1, map);
        
        map.put(cur, pos + neg);
        return pos + neg;
    }
}