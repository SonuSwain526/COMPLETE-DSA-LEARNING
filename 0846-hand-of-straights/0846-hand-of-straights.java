class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        HashMap <Integer, Integer> freq = new HashMap<>();

        for (int el: hand) freq.put (el, freq.getOrDefault(el, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int el: freq.keySet()) pq.add (el);

        while (!pq.isEmpty()) {
            int cur = pq.peek();

            for (int i = 0; i < groupSize; i++){

                int next = cur + i;

                if (!freq.containsKey(next)){
                    return false;
                }

                freq.put (next, freq.get(next) - 1);

                if (freq.get(next) == 0){

                    if (pq.peek() != next) return false;

                    pq.poll();
                    freq.remove(next);
                }
            }
        }

        return true;
    }
}