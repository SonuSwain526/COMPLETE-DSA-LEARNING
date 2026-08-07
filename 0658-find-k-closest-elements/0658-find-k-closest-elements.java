class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return Integer.compare(b.getValue(), a.getValue());
                    }

                    return Integer.compare(b.getKey(), a.getKey());
                }
        );

        int ix = 0;
        while (pq.size() < k) {
            pq.add( new Pair<>(arr[ix], (Math.abs(arr[ix] - x))) );
            ix++;
        }

        for (int i = ix; i < n; i++){
            int diff = Math.abs(x - arr[i]);
            Pair<Integer, Integer> top = pq.peek();

            if (diff < top.getValue() ||
                (diff == top.getValue() && arr[i] < top.getKey())) {

                pq.poll();
                pq.add(new Pair<>(arr[i], diff));
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()){
            ans.add(pq.poll().getKey());
        }

        Collections.sort(ans);
        return ans;
    }
}