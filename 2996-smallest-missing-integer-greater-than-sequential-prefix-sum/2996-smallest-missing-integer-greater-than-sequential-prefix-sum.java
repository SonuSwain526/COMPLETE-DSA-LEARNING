class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE;

        for (int el: nums) {
            max = Math.max(max, el);
            set.add(el);
        }
        int x = Integer.MIN_VALUE;
        int sum = nums[0];
        boolean b = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                x = sum;
                b = true;
                break;
            }else {
                sum += nums[i];
            }
        }
        if (!b) x = sum;
        if (max < x) return x;
        for (int i = x; i <= max + 1; i++) {
            if (!set.contains(i)) return i;
        }

        return -1;
    }
}