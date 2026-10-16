class Solution {
    public int hammingWeight(int n) {
        int c = 0;
        for (int i = 30; i >= 0; i--) {
            int x = (int)Math.pow(2, i);
            if (n >= x) {
                n = n - x;
                c++;
            }
        }
        return c;
    }
}