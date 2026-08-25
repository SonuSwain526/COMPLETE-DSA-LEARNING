class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for (int x: nums) s.add(x);
        int x = k;
        while (true) {
            if (!s.contains(k)) return k;
            k = k + x;
        }
    }
}