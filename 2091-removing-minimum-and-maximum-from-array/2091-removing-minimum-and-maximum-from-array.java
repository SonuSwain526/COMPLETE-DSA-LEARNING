class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int xfast = 0;
        int xlast = 0;
        int yfast = 0; 
        int ylast = 0;
        int minima = 0; 
        int maxima = 0;
        for (int i = 0; i < n; i++) {
            if (nums[minima] > nums[i]) minima = i;
            if (nums[maxima] < nums[i]) maxima = i;
        }
        xfast = minima + 1;
        xlast = n - minima;
        yfast = maxima + 1;
        ylast = n - maxima;

        int x = Math.min(xfast, Math.min(xlast, Math.min(yfast, ylast)));
        int ans = 0;
        if (x == xfast) {
            ans += xfast;
            yfast -= xfast;
            ans += Math.min(yfast, ylast);
            return ans;
        }
        if (x == xlast) {
            ans += xlast;
            ylast -= xlast;
            ans += Math.min(yfast, ylast);
            return ans;
        }
        if (x == yfast) {
            ans += yfast;
            xfast -= yfast;
            ans += Math.min(xfast, xlast);
            return ans;
        }
        if (x == ylast) {
            ans += ylast;
            xlast -= ylast;
            ans += Math.min(xfast, xlast);
            return ans;
        }
        return 0;
    }
}