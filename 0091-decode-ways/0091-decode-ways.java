class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dp(s, 0, dp);
    }

    int dp(String s, int ix, int[] dp) {
        if (ix >= s.length()) return 1;

        if (dp[ix] != -1) return dp[ix];

        int sum = 0;
        for (int i = ix; i < s.length(); i++) {
            String cur = s.substring(ix, i + 1);
            if (cur.charAt(0) == '0') continue;
            if (cur.length() > 2) continue;
            int no = Integer.parseInt(cur);
            if (cur.charAt(0) == '0' || !(no <= 26 && no > 0)) continue;

            sum += dp(s, i + 1, dp);
        }
        return dp[ix] = sum;
    }
}