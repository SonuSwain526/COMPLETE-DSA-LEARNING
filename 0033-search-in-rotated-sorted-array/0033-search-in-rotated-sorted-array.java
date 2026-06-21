class Solution {
    public int search(int[] nums, int target) {
        if(nums.length <= 1){
            if(nums.length == 0) return -1;
            else if(nums[0] == target) return 0;
            else return -1;

        }
        int x = bs(nums);
        int a1 = bs1(nums, 0, x, target);
        System.out.println(x);
        int a2 = bs1(nums, x+1, nums.length-1, target);
        if(a1 != -1) return a1;
        else return a2;
    }

    public int bs(int[] a){
        int l = 0, r = a.length-1;

        while(l <= r){
            int m = l + (r - l)/2;
            if(a[l] == a[r] ) return l;
            if(a[l] < a[m]) l = m;
            else r = m;
        }
        return l;
    }

    public int bs1(int[] a, int l, int r, int t){
            while(l <= r){
                int m = l + (r - l)/2;

                if(a[m] == t) return m;
                else if(a[m] < t) l = m+1;
                else r = m-1;
            }
        return -1;
    }
}