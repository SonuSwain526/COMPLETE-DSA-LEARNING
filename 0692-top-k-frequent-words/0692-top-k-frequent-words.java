import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        int n = words.length;

        HashMap<String, Integer> map = new HashMap<>();

        // Count frequency
        for (int i = 0; i < n; i++) {
            map.put(
                words[i],
                map.getOrDefault(words[i], 0) + 1
            );
        }

        // Max heap
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {

                int freqA = map.get(a);
                int freqB = map.get(b);

                // Higher frequency first
                if (freqA != freqB) {
                    return Integer.compare(freqB, freqA);
                }

                // Same frequency -> lexicographically smaller first
                return a.compareTo(b);
            }
        );

        // Add all unique words
        for (String word : map.keySet()) {
            pq.add(word);
        }

        List<String> ans = new ArrayList<>();

        // Take top K
        while (!pq.isEmpty() && ans.size() < k) {
            ans.add(pq.poll());
        }

        return ans;
    }
}