class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        int[] freq = new int[26];

        for (char c: s.toCharArray()){
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            if (freq[i] != 0) pq.add(new Pair<>((char) (i + 'a'), freq[i]));
        }

        StringBuilder sb =  new StringBuilder();

        while (!pq.isEmpty()){

            Pair<Character, Integer> fst = pq.poll();

            if (pq.isEmpty()){
                if (fst.getValue() > 1) return "";

                sb.append(fst.getKey()); break;
            }

            Pair<Character, Integer> sec = pq.poll();

            sb.append(fst.getKey());
            sb.append(sec.getKey());

            if (fst.getValue() - 1 != 0 ) pq.add(new Pair<>(fst.getKey(), fst.getValue() - 1));

            if (sec.getValue() - 1 != 0 ) pq.add(new Pair<>(sec.getKey(), sec.getValue() - 1));

            // if (b){
            //     sb.append(fst.getKey());
            //     if (fst.getValue() - 1 != 0 ) pq.add(new Pair<>(fst.getKey(), fst.getValue() - 1));
            //     sb.append(sec.getKey());
            //     if (sec.getValue() - 1 != 0 ) pq.add(new Pair<>(sec.getKey(), sec.getValue() - 1));
            // }else {
            //     sb.append(fst.getKey());
            //     if (fst.getValue() - 1 != 0 ) pq.add(new Pair<>(fst.getKey(), fst.getValue() - 1));                
            // }

            // if (sb.length() > 1 && sb.charAt(sb.length()-1) == sb.charAt(sb.length() -2)) return ""; 
        }

        // if (sb.length() > 1 && sb.charAt(sb.length()-1) == sb.charAt(sb.length() -2)){
        //     return ""; 
        // }

        return sb.toString();

    }
}