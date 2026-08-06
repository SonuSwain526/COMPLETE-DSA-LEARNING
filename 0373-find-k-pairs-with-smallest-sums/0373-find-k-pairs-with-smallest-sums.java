class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int m = nums2.length;
        
        PriorityQueue<Pair<Integer, int[]>> pq = new PriorityQueue<>(
            (a, b) -> a.getKey() - b.getKey()
        );

        Set<Pair<Integer, Integer>> set = new HashSet<>();

        pq.add(new Pair<>((nums1[0]+nums2[0]), new int[]{0, 0}));
        set.add(new Pair<>(0, 0));

        List<List<Integer>> ans = new ArrayList<>();

        while ( ans.size() < k && !pq.isEmpty()){

            Pair<Integer, int[]> x = pq.poll();
            int i = x.getValue()[0];
            int j = x.getValue()[1];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if ( j+1 < m &&!set.contains(new Pair<>(i, j+1))){
                set.add(new Pair<>(i, j+1));
                pq.add(new Pair<>((nums1[i] + nums2[j+1] ), new int[]{i, j+1}));
            }
            if ( i+1 < n &&!set.contains(new Pair<>(i+1, j))){
                set.add(new Pair<>(i+1, j));
                pq.add(new Pair<>((nums1[i+1] + nums2[j] ), new int[]{i+1, j}));
            }
            if ( j+1 < m && i+1 < n &&!set.contains(new Pair<>(i+1, j+1))){
                set.add(new Pair<>(i+1, j+1));
                pq.add(new Pair<>((nums1[i+1] + nums2[j+1] ), new int[]{i+1, j+1}));
            }
        }

        return ans;

    }
}