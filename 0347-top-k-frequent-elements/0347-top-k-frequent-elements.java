class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if (nums.length== 1) return nums;

        HashMap<Integer, Integer> x = new HashMap<>();

        for (int elem: nums){
            x.put(elem, x.getOrDefault(elem, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(x.keySet());

        list.sort((a, b) -> Integer.compare(x.get(b), x.get(a)));

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}