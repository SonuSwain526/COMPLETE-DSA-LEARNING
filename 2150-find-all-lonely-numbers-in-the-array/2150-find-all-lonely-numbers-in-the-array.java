class Solution {
    public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> s= new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x: nums) {
            s.add(x);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int x: nums) {
            if (!s.contains(x+1) && !s.contains(x-1) && map.get(x) == 1) ans.add(x);
        }

        return ans;
    }
}