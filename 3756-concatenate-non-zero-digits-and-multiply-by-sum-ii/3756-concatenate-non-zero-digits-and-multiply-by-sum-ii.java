// class Solution {

//     static final int MOD = 1_000_000_007;

//     public int[] sumAndMultiply(String s, int[][] q) {

//         int[] ans = new int[q.length];
//         int n = s.length();

//         // Prefix sum of digits
//         int[] prefSum = new int[n];
//         prefSum[0] = s.charAt(0) - '0';

//         for (int i = 1; i < n; i++) {
//             prefSum[i] = prefSum[i - 1] + (s.charAt(i) - '0');
//         }

//         // Prefix string of non-zero digits
//         String[] prefNo = new String[n];
//         StringBuilder sb = new StringBuilder();

//         for (int i = 0; i < n; i++) {
//             if (s.charAt(i) != '0') {
//                 sb.append(s.charAt(i));
//             }
//             prefNo[i] = sb.toString();
//         }

//         // Answer queries
//         for (int i = 0; i < q.length; i++) {

//             int l = q[i][0];
//             int r = q[i][1];

//             int sum = prefSum[r] - (l > 0 ? prefSum[l - 1] : 0);

//             int before = (l == 0) ? 0 : prefNo[l - 1].length();
//             int len = prefNo[r].length() - before;

//             long number = 0;

//             if (len > 0) {
//                 number = modString(prefNo[r].substring(before));
//             }

//             ans[i] = (int) ((number * sum) % MOD);
//         }

//         return ans;
//     }
//     static long modString(String s) {
//         long res = 0;
//         long mod = 1_000_000_007L;

//         for (char c : s.toCharArray()) {
//             res = (res * 10L + (c - '0')) % mod;
//         }

//         return res;
//     }
// }

class Solution {

    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        long[] preNum = new long[n + 1];
        int[] preSum = new int[n + 1];
        int[] preLen = new int[n + 1];

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 1; i <= n; i++) {

            int d = s.charAt(i - 1) - '0';

            preSum[i] = preSum[i - 1];
            preLen[i] = preLen[i - 1];
            preNum[i] = preNum[i - 1];

            if (d != 0) {
                preSum[i] += d;
                preLen[i]++;
                preNum[i] = (preNum[i - 1] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int sum = preSum[r + 1] - preSum[l];

            int len = preLen[r + 1] - preLen[l];

            long x = (preNum[r + 1]
                    - (preNum[l] * pow10[len]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}