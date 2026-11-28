class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int ans = 0;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i == k) q.add(new Pair<>(tickets[i], 0));
            else q.add(new Pair<>(tickets[i], -1));
        }
        while(!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            int val = cur.getKey() - 1;
            if (val == 0) {
                if (cur.getValue() == 0) return ans + 1;
            }else {
                if (cur.getValue() == -1) q.add(new Pair<>(val, -1));
                else q.add(new Pair<>(val, 0));
            }
            ans++;
        }
        return ans;
    }
}