class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0; 

        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            freq[s.charAt(i) - 'a']++;
            int cur = 1;

            for (int j = i + 1; j < s.length(); j++) {
                if (++freq[s.charAt(j) - 'a'] > 2) {
                    max = Math.max(max, cur);
                    break;
                }else cur++;
                max = Math.max(max, cur);
            }
            max = Math.max(max, cur);
        }

        return max;
    }
}