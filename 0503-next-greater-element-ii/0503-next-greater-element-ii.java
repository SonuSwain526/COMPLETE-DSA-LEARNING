class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = n-1; i >= 0; i--){
            if(s.isEmpty()){
                ans[i] = -1;
                s.push(nums[i]);
            }else{
                if(nums[i] < s.peek()){
                    ans[i] = s.peek();
                    s.push(nums[i]);
                }else{
                    while(!s.isEmpty() && nums[i] >= s.peek()){
                        s.pop();
                    }
                    if(s.isEmpty()){
                        ans[i] = -1;
                    }else ans[i] = s.peek();

                    s.push(nums[i]);
                }
            }
        }

        for(int i = n-1; i >= 0; i--){
            if(s.isEmpty()){
                ans[i] = -1;
                s.push(nums[i]);
            }else{
                if(nums[i] < s.peek()){
                    ans[i] = s.peek();
                    s.push(nums[i]);
                }else{
                    while(!s.isEmpty() && nums[i] >= s.peek()){
                        s.pop();
                    }
                    if(s.isEmpty()){
                        ans[i] = -1;
                    }else ans[i] = s.peek();

                    s.push(nums[i]);
                }
            }
        }

        return ans;
    }
}