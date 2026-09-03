class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        boolean b = true;
        for (int x: nums1) {
            if (x % 2 == 0) {
                b = false;
                break;
            }
        }
        if (b) return true;
        b = true;
        for (int x: nums1) {
            if (x % 2 != 0) {
                b = false;
                break;
            }
        }
        if (b) return true;

        if (nums1[0] % 2 == 0) return false;
        return true;
    }
}