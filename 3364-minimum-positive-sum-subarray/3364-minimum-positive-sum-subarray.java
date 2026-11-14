class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int size = 0;
        int ans = Integer.MAX_VALUE;
        int n = nums.size();

        int cur = 0;

        int[] ps = new int[n];
        ps[0] = nums.get(0);
        for (int i = 1; i < n; i++) {
            ps[i] = nums.get(i) + ps[i - 1];
        }

        for (int i = 0; i < n; i++) {
            cur = 0;
            for (int j = i; j < n; j++) {
                cur = ps[j] - ((i == 0)? 0 : ps[i - 1]);
                size = (j - i)+1;
                if (size <= r && size >= l && cur > 0) ans = Math.min(ans, cur);
            }
        }

       
        return (ans == Integer.MAX_VALUE)? -1 : ans;
    }
}