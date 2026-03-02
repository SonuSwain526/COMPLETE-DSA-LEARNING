class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length >=2){
            if(nums[0] > nums[1]){
                return 0;
            }
            else if(nums[1]>nums[0] && nums.length == 2){
                return 1;
            }
            else if(nums[nums.length - 1] > nums[nums.length - 2]){
                return (nums.length - 1);
            }
        }
        int s = 0, e = nums.length-1;
        while(s<=e) {
            int mid = (s+e)/2;
            if((mid != 0 && mid!= nums.length-1) && (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])){
                return mid;
            }
            else if((nums[mid] > nums[s] && nums[mid] > nums[e]) ){
                s++;
                e--;
            }else if(((mid != 0 && mid!= nums.length-1) && (nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]))||(nums[mid] >= nums[s] && nums[mid] < nums[e])){
                s = mid+1;
            }else
                e = mid-1;
        }
        return s;
    }
}