class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        // int count = 0;
        // for (int i = 30; i >= 0; i--) {
        //     int cur = (int) Math.pow(2, i);
        //     if (cur <= n) {
        //         n = n - cur;
        //         count++;
        //     }
        //     if (count > 1) return false;
        // }
        // return (count == 1) && n == 0;
        return (n & (n - 1)) == 0;
    }
}