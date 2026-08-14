class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int max = 0; 

        int[] freq = new int[26];

        int st = 0; 
        int en = 0; 

        while (st < n && en < n ) {
            freq[s.charAt(en) - 'a']++;
            while (freq[s.charAt(en) - 'a'] > 2 && st < n) {
                freq[s.charAt(st++) - 'a']--;
            }
            int size = en - st + 1;
            en++;
            max = Math.max(max, size);
        }

        // for (int i = 0; i < s.length(); i++) {
        //     int[] freq = new int[26];
        //     freq[s.charAt(i) - 'a']++;
        //     int cur = 1;

        //     for (int j = i + 1; j < s.length(); j++) {
        //         if (++freq[s.charAt(j) - 'a'] > 2) {
        //             max = Math.max(max, cur);
        //             break;
        //         }else cur++;
        //         max = Math.max(max, cur);
        //     }
        //     max = Math.max(max, cur);
        // }

        return max;
    }
}