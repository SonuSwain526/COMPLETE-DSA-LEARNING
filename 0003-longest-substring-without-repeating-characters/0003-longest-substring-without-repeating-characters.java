class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)return 1;
        if(s.length() == 0)return 0;
        List<Character> b = new ArrayList<>();
        int c = 0;

        int i = 0;
        int cur = 0;
        while( i < s.length()){
            if(!b.contains(s.charAt(i))){
                b.add(s.charAt(i));
                cur++;
                i++;
            }else{
                int ch = 0;
                for (int j = 0; j < b.size(); j++) {
                    if (b.get(j) == s.charAt(i)) {
                        ch = j;
                        break;
                    }
                }
                cur = 0;
                i = i - (b.size()-1 - ch);
                b = new ArrayList<>();
            }
            c = Math.max(c, cur);
        }

        return c;
    }
}