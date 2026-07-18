class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int x: nums){
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        if (max % min == 0) return min;
        
        int l = 1, r = min;

        while (r > 0){
            if(min % r == 0 && max % r == 0) return r;
            r--;
        }
        // int ans = 0;
        // while (l <= r){
        //     int mid = l + (r - l) / 2;

        //     if(min % mid == 0 && max % mid == 0){
        //         ans = mid;
        //         l = mid + 1;
        //     }else r = mid - 1;
        // }

        return 1;
    }
}