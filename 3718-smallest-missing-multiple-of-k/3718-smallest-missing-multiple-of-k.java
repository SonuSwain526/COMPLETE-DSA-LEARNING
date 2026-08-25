class Solution {
    public int missingMultiple(int[] nums, int k) {
        // Set<Integer> s = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int x: nums) {
            if (x % k == 0) {
                if (!list.contains(x/k)) list.add(x / k);
            }
        }
        Collections.sort(list);
        // System.out.println(list);
        int cur = 1;
        for (int x: list) {
            if (x != cur) return cur * k;
            cur++;
        }
        // int x = k;
        // while (true) {
        //     if (!s.contains(k)) return k;
        //     k = k + x;
        // }
        return (list.size() + 1 ) * k;
    }
}