class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> x = new HashMap<>();

        for (int[] cur: edges) {
            x.put(cur[0], x.getOrDefault(x.get(cur[0]), 0) + 1);
            if (x.get(cur[0]) > 1) return cur[0];
            x.put(cur[1], x.getOrDefault(x.get(cur[1]), 0) + 1 );
            if (x.get(cur[1]) > 1) return cur[1];
        }
        return -1;
    }
}