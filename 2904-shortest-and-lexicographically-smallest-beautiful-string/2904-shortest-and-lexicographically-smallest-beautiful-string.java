class Solution {

    public static String shortestBeautifulSubstring(String s, int k) {

        String ans = "";

        int l = 0;
        int ones = 0;

        for (int r = 0; r < s.length(); r++) {

            if (s.charAt(r) == '1')
                ones++;

            while (ones >= k) {

                // Remove leading zeros
                while (l <= r && s.charAt(l) == '0')
                    l++;

                String cur = s.substring(l, r + 1);

                if (ans.equals("")
                        || cur.length() < ans.length()
                        || (cur.length() == ans.length()
                            && cur.compareTo(ans) < 0)) {

                    ans = cur;
                }

                // Remove leftmost 1
                if (s.charAt(l) == '1')
                    ones--;

                l++;
            }
        }

        return ans;
    }
}