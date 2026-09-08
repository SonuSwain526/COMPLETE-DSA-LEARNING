class Solution {
    public int countCommas(int n) {
        if (n < 1000) return 0;
        // 1000 - 100000
        return n - 1000 + 1;
    }
}