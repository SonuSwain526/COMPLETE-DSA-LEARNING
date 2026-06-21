class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1) return 1;
        Arrays.sort(nums);
        int c = 1;
        int max = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            if(nums[i]+1 != nums[i+1]){
                c = 1;
            }else c++;
             max = Math.max(max, c);
        }

        return Math.max(c, max);
    }
}