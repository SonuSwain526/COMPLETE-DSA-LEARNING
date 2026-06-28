class Solution {
    public int trap(int[] h) {
        // Stack<Integer> s = new Stack<>();
        
        // int n = h.length;
        // int[] pge = new int[n];
        // int[] nge = new int[n];

        // for(int i = 0; i < n; i++){
        //     while (!s.isEmpty() && h[s.peek()] <= h[i]){
        //         s.pop();
        //     }
        //     if(s.isEmpty()) pge[i] = -1;
        //     else pge[i] = s.peek();

        //     s.push(i);
        // }
        // s = new Stack<>();
        // for(int i = n-1; i >= 0; i--){
        //     while (!s.isEmpty() && h[s.peek()] <= h[i]){
        //         s.pop();
        //     }
        //     if(s.isEmpty()) nge[i] = -1;
        //     else nge[i] = s.peek();

        //     s.push(i);
        // }

        int n = h.length;
        int ng = -1;
        int pg = -1;
        int[] fnge = new int[n];
        int[] fpge = new int[n]; 

        for(int i = 0; i < n; i++){
            if(pg == -1 || h[i] > h[pg]){
                pg = i;
                fpge[i] = -1;
            }else fpge[i] = pg;
        }

        for(int i = n-1; i >= 0; i--){
            if(ng == -1 || h[i] > h[ng]){
                ng = i;
                fnge[i] = -1;
            }else fnge[i] = ng;
        }

        // int max = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(fpge[i] != -1 && fnge[i] != -1)
                sum += Math.min(h[fpge[i]], h[fnge[i]]) - h[i];
        }

        return sum;
    }
}