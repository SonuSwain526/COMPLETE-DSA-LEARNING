class Solution {
    public long countCommas(long n) {
        long ans = 0;
        if (n < 1000) return 0;

        if (n < Math.pow(10, 6)) {
            return (n - 1000) + 1;
        }
        ans += Math.pow(10, 6) - 1000;
        if (n >= Math.pow(10, 6) && n < Math.pow(10, 9)) {
            ans += (n - Math.pow(10, 6) + 1 ) * 2;
            return ans;
        }
        ans += ( Math.pow(10, 9) - Math.pow(10, 6) ) * 2;
        if (n >= Math.pow(10, 9) && n < Math.pow(10, 12)) {
            ans += (n - Math.pow(10, 9) + 1 ) * 3;
            return ans;
        }
        ans += ( Math.pow(10, 12) - Math.pow(10, 9) ) * 3;
        if (n >= Math.pow(10, 12) && n < Math.pow(10, 15)) {
            ans += (n - Math.pow(10, 12) + 1 ) * 4;
            return ans;
        }
        long x = 3998998998999005L;
        return x;
        // ans += ( Math.pow(10, 15) - Math.pow(10, 12) ) * 4;
        // return ans + 1;
    }
}