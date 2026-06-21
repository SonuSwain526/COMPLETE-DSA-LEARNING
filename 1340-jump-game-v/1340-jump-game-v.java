// class Solution {

//     public int maxJumps(int[] arr, int d) {

//         int ans = 1;

//         for(int i = 0; i < arr.length; i++){
//             ans = Math.max(ans, solve(arr, d, i));
//         }

//         return ans;
//     }

//     public int solve(int[] arr, int d, int ix){

//         int ans = 1;

//         // RIGHT
//         for(int i = ix + 1; i <= Math.min(arr.length - 1, ix + d); i++){

//             // blocked
//             if(arr[i] >= arr[ix]) break;

//             ans = Math.max(ans, 1 + solve(arr, d, i));
//         }

//         // LEFT
//         for(int i = ix - 1; i >= Math.max(0, ix - d); i--){

//             // blocked
//             if(arr[i] >= arr[ix]) break;

//             ans = Math.max(ans, 1 + solve(arr, d, i));
//         }

//         return ans;
//     }
// }

class Solution {

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];

        int ans = 1;

        for(int i = 0; i < n; i++){
            ans = Math.max(ans, dfs(arr, d, i, dp));
        }

        return ans;
    }

    public int dfs(int[] arr, int d, int ix, int[] dp){

        if(dp[ix] != 0) return dp[ix];

        int ans = 1;

        // RIGHT
        for(int i = ix + 1; i <= Math.min(arr.length - 1, ix + d); i++){

            if(arr[i] >= arr[ix]) break;

            ans = Math.max(ans, 1 + dfs(arr, d, i, dp));
        }

        // LEFT
        for(int i = ix - 1; i >= Math.max(0, ix - d); i--){

            if(arr[i] >= arr[ix]) break;

            ans = Math.max(ans, 1 + dfs(arr, d, i, dp));
        }

        return dp[ix] = ans;
    }
}