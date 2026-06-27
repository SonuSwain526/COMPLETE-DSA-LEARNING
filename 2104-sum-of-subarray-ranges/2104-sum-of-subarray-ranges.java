class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> s =new Stack<>();
        int n = nums.length;
        int[] pse = new int[n];
        int[] fse = new int[n];
        int[] pge = new int[n];
        int[] fge = new int[n];

        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && nums[s.peek()] > nums[i]){
                s.pop();
            }

            if(s.isEmpty()) pse[i] = -1;
            else{
                pse[i] = s.peek();
            }
            s.push(i);

        }
            
        s = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!s.isEmpty() && nums[s.peek()] >= nums[i]){
                s.pop();
            }

            if(s.isEmpty()) fse[i] = n;
            else{
                fse[i] = s.peek();
            }
            s.push(i);

        }

        s = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && nums[s.peek()] < nums[i]){
                s.pop();
            }

            if(s.isEmpty()) pge[i] = -1;
            else{
                pge[i] = s.peek();
            }
            s.push(i);

        }

        s = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]){
                s.pop();
            }

            if(s.isEmpty()) fge[i] = n;
            else{
                fge[i] = s.peek();
            }
            s.push(i);

        }

        long sm = 0;
        long lr = 0;
        for(int i = 0; i < n; i++){
            long lastSm = i - pse[i];
            long futSm = fse[i] - i;
            long lastLr = pge[i] - i;
            long futLr = i - fge[i];

            sm = (sm + (lastSm * futSm * nums[i]));
            lr = (lr + (lastLr * futLr * nums[i]));
        }

        return (lr - sm);
    }
}