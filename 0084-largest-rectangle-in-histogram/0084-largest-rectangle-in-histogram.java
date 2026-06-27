class Solution {
    public int largestRectangleArea(int[] h) {
        int max = Integer.MIN_VALUE;
        int n = h.length;
        // for(int i = 0; i < h.length; i++){
        //     int cur = 0;
        //     for(int j = i; j < h.length; j++){
        //         if(h[j] < h[i]) break;
        //         cur++;
        //     }

        //     for(int j = i-1; j >= 0; j--){
        //         if(h[j] < h[i]) break;
        //         cur++;
        //     }

        //     max = Math.max(cur * h[i], max);
        // }


        int[] pse = new int[n];
        int[] fse = new int[n];

        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && h[i] < h[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()) pse[i] = -1;
            else pse[i] = s.peek();
            s.push(i);
        }
        s = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!s.isEmpty() && h[i] <= h[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()) fse[i] = n;
            else fse[i] = s.peek();
            s.push(i);
        }

        for(int i = 0; i < n; i++){
            int dif = fse[i] - pse[i]-1;
            // if(fse[i] == n && pse[i] == 0) dif = n;
            max = Math.max(max, dif*h[i]); 
        }

        return max;
    }
}