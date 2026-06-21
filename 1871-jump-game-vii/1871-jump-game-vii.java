// // class Solution {
// //     static boolean b;
// //     public boolean canReach(String s, int minJump, int maxJump) {
// //         b = false;
// //         boolean[] bb = new boolean[s.length()];
// //         return test(s, minJump, maxJump, 0, bb);
// //     }
// //         public boolean test(String s, int minJump, int maxJump, int ix, boolean[] bb) {

// //         if (ix == s.length()-1){
// //             b = true;
// //             return true;
// //         }

// //         bb[ix] = true;
// //         for (int i = ix+1; i < s.length(); i++) {
// //             if(!bb[i] && ix + minJump <= i && i <= Math.min(ix + maxJump, s.length()-1) && s.charAt(i) == '0'){
// //                 test(s, minJump, maxJump, i, bb);
// //             }
// //         }

// //         return b;
// //     }
// // }

// class Solution {

//     public boolean canReach(String s, int minJump, int maxJump) {

//         boolean[] visited = new boolean[s.length()];

//         return solve(s, minJump, maxJump, 0, visited);
//     }

//     public boolean solve(String s, int minJump, int maxJump,
//                          int ix, boolean[] visited){

//         if(ix == s.length() - 1){
//             return true;
//         }

//         visited[ix] = true;

//         for(int i = ix + minJump;
//             i <= Math.min(ix + maxJump, s.length() - 1);
//             i++){

//             if(s.charAt(i) == '0' && !visited[i]){

//                 if(solve(s, minJump, maxJump, i, visited)){
//                     return true;
//                 }
//             }
//         }

//         return false;
//     }
// }

class Solution {

    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] f = new int[n];
        int[] pre = new int[n];
        f[0] = 1;
        // since we start dynamic programming from i=minJump, we need to precompute the prefix sums for the part [0, minJump)
        for (int i = 0; i < minJump; i++) {
            pre[i] = 1;
        }
        for (int i = minJump; i < n; i++) {
            int left = i - maxJump;
            int right = i - minJump;
            if (s.charAt(i) == '0') {
                int total = pre[right] - (left <= 0 ? 0 : pre[left - 1]);
                f[i] = total != 0 ? 1 : 0;
            }
            pre[i] = pre[i - 1] + f[i];
        }
        return f[n - 1] == 1;
    }
}