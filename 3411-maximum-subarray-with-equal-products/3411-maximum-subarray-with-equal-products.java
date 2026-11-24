class Solution {
    public int maxLength(int[] nums) {
        int ans = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int mul = 1;
            for (int j = i; j < n; j++) {
                mul *= nums[j];
                int cur = gcd(i, j, nums) * lcm(i, j, nums);
                if (cur == mul) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
    int gcd(int i, int j, int[] nums) {
        int ans = 0;

        for (int x = i; x <= j; x++) {
            ans = gcd(ans, nums[x]);
        }

        return ans;
    }

    int lcm(int i, int j, int[] nums) {
        int ans = nums[i];

        for (int x = i + 1; x <= j; x++) {
            ans = (ans / gcd(ans, nums[x])) * nums[x];
        }

        return ans;
    }

}