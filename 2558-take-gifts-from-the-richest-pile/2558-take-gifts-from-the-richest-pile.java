class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());

        for (int elem: gifts) maxh.add(elem);

        for (int i = 0; i < k; i++){
            int x = (int) Math.sqrt(maxh.poll());
            maxh.add(x);
        }

        long sum = 0;

        while (!maxh.isEmpty()){
            sum += (long) maxh.poll();
        }

        return sum;
    }
}