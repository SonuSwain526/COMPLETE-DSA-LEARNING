class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean b = false;
        int k = 0;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {

                // CHANGED: find the smallest element greater than nums[i - 1]
                int idx = i;
                for (int j = i; j < n; j++) {
                    if (nums[j] > nums[i - 1] && nums[j] <= nums[idx]) {
                        idx = j;
                    }
                }

                int temp = nums[i - 1];
                nums[i - 1] = nums[idx];
                nums[idx] = temp;

                k = i;
                b = true;
                break;
            }
        }

        if (!b) {
            Arrays.sort(nums);
            return;
        }

        if (k == n - 1) return;

        int[] x = new int[n - k];

        for (int i = 0; i < x.length; i++) {
            x[i] = nums[i + k];
        }

        Arrays.sort(x);

        for (int i = k; i < n; i++) {
            nums[i] = x[i - k];
        }
    }
}