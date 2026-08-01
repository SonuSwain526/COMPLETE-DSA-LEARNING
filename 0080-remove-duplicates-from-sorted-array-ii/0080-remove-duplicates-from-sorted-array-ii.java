class Solution {
    public int removeDuplicates(int[] nums) {
        int total= 0;
        int cur = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length - total; i++){

            if (cur != nums[i]){
                if (count > 2) {
                    total += count - 2;
                    int ix = i - (count - 2);
                    for (int j = i; j < nums.length; j++){
                        nums[ix++] = nums[j];
                    }
                    i -= count-2;
                }
                count = 1;
            }else count++;
            cur = nums[i];

        }
        if (count > 2) {
            total += count - 2;
        }
        System.out.println(nums.length - count);
        return nums.length - total;
    }
}