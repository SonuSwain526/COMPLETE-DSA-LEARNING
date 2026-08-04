class Solution {
    public String frequencySort(String s) {

        int[] freq = new int[52];

        HashMap<Character, Integer> x = new HashMap<>();

        for (char c : s.toCharArray()){
            x.put(c, x.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>(
            (a, b) -> b.getKey() - a.getKey()
        );

        for (char c : x.keySet()){
            pq.add(new Pair<>(x.get(c), c));
        }
        
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()){
            Pair<Integer, Character> pair = pq.poll();

            char c = pair.getValue();
            int f = pair.getKey();

            for (int i = 0; i < f; i++) sb.append(c);
        }

        return sb.toString();
    }
}