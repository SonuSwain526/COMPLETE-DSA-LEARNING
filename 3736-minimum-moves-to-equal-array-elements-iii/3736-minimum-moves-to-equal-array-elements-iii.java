class Solution {
    public int minMoves(int[] nums) {
        int l = 0;

        for (int x: nums) l = Math.max(l, x);
        int ans = 0;

        for (int x: nums) ans += l - x;

        return ans;
    }
}