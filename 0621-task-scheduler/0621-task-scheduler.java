class Solution {
    public int leastInterval(char[] tasks, int m) {

        int n = tasks.length;

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        int[] freq = new int[26];

        for (int i = 0; i < n; i++){
            freq[tasks[i] - 'A']++;
        }

        for (int i = 0; i < 26; i++){
            if (freq[i] != 0) pq.add(new Pair<>((char) (i + 'A'), freq[i]));
        }

        int ans = 0; 

        while (!pq.isEmpty()) {
            
            List<Pair<Character, Integer>> list = new ArrayList<>();

            int c = 0;
            
            while (!pq.isEmpty() && c < m+1){
                list.add( pq.poll() );
                c++;
            }

            for (int i = 0; i < list.size(); i++){
                int fr = list.get(i).getValue() - 1;
                char ch = list.get(i).getKey();

                if (fr != 0) pq.add(new Pair<>(ch, fr));
            }

            if (pq.isEmpty()) ans += c;
            else ans += m + 1;
        }

        return ans;
    }
}