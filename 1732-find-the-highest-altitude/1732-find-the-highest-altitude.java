class Solution {
    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;
        int x = 0;
        for (int i = 0; i<gain.length; i++){
            max = Math.max(x, max);
            x += gain[i];
        }

        return Math.max(max, x);
    }
}