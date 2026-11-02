class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        if (nums.length % 2 != 0) {
            for (int x: nums) ans += Math.abs(x - nums[(nums.length) / 2]);
        }else{
            int a = 0, b = 0;
            for (int x: nums) a += Math.abs(x - nums[(nums.length) / 2]);
            for (int x: nums) b += Math.abs(x - nums[((nums.length) / 2) - 1]);
            ans = Math.min(a, b);
        }
        
        // int l = Integer.MIN_VALUE, s = Integer.MAX_VALUE;
        // for (int x: nums) {
        //     l = Math.max(l, x);
        //     s = Math.min(s, x);
        // }
        // int mid = 0;
        // if ((l - s) % 2 == 0) mid = (l - s) / 2;
        // else mid = (l - s) / 2 + 1;

        // int ans = 0;
        
        // for (int x: nums) ans += Math.abs(mid - x);

        return ans;
    }
}