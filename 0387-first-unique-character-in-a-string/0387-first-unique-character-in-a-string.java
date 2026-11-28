class Solution {
    public int firstUniqChar(String s) {
        int[] b = new int[26];
        // for (int i = 0; i < 26; i++) b[i] = false;
        for (char c: s.toCharArray()) {
            b[(c - 'a')]++;
        }
        int i = 0;
        for (char c: s.toCharArray()) {
            if (b[c - 'a'] == 1) return i;
            i++;
        }
       
        return -1;
    }
}