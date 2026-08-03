class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] x = new int[n];

        for (int i = 0; i < n; i++){
            x[i] = 1;
        }

        for (int i = 1; i < n; i++){
            if (ratings[i-1] < ratings[i]) x[i] = x[i-1] +1;
        }

        for (int i = n - 2; i >= 0; i--){
            if (ratings[i + 1] < ratings[i]){
                x[i] = Math.max(x[i], x[i+1] + 1);
            }
        }

//         for (int i = 0; i < n; i++){

//             int cur = ratings[i];

//             if (i != 0 && i != n-1){
//                 if (cur >= ratings[i+1] && cur >= ratings[i-1]){
//                     // if (cur == ratings[i-1]) x[i] = x[i-1];
//                     if (cur == ratings[i+1]) x[i] = x[i-1] + 1; 
//                     else x[i] = Math.max(Math.max(x[i-1], x[i+1]), 1) + 1;
//                 }else if (cur < ratings[i+1] && cur < ratings[i-1]){
//                     x[i] = 1;
//                 }else{
//                     if (cur > ratings[i+1]) x[i] = 2;
//                     else x[i] = x[i-1] +1;
// //                 
//                 }
//             }else {
//                 if (i == 0) {
//                     if (cur > ratings[i+1]) x[i] = 2;
//                     else x[i] = 1;
//                 }else{
//                     if (cur > ratings[i-1]) x[i] = x[i-1] + 1;
//                     else x[i] = 1;                    
//                 }
//             }
//         }

        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += x[i];
        }
        return sum;
    }
}