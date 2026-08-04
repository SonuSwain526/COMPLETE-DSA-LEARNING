class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int n = stones.length;

        for (int i = 0; i < n; i++){
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            maxHeap.add(Math.abs(first - second));
        }

        if (maxHeap.isEmpty()) return 0;
        return maxHeap.peek();
    }
}