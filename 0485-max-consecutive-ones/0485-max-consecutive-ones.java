class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c = 0;
        int max = 0;
        for (int x : nums){
            if (x == 0) {
                max = Math.max(c, max);
                c = 0;
            }else c++;
        }

        return Math.max(c, max);
    }
}