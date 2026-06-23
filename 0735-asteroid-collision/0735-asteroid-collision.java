class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> s = new Stack<>();
        s.push(a[0]);

        for(int i = 1; i < a.length; i++){
            if(s.isEmpty()) {s.push(a[i]);continue;}
            boolean x = s.peek() > 0;
            boolean y = a[i] > 0;
            boolean bb = false;
            if(x  && !y){
                while(!s.isEmpty() && (x  && !y)){
                    // x = s.peek() > 0;
                    // y = a[i] > 0;
                    if(Math.abs(s.peek()) == Math.abs(a[i])){
                        s.pop();
                        bb = false;
                        break;
                    }else if( Math.abs(s.peek()) > Math.abs(a[i])){bb = false; break;}
                    else {
                        bb = true;
                        s.pop();
                    }
                    if(!s.isEmpty()){
                        x = s.peek() > 0;
                        y = a[i] > 0;
                    }
                }
                if(bb) s.push(a[i]);
            }else s.push(a[i]);
        }
        // int expt = 0;
        // for(int i = 0; i < a.length; i++){
            
        //     if(expt >= 0 && a[i] >= 0) s.push(a[i]);
        //     else if(expt <= 0 && a[i] <= 0) s.push(a[i]);
        //     else {
        //         if(s.peek() == x[i])
        //     }
        //     if(i = 0) s.push(a[i]);
        // // }
        // int[] ans = new int[s.size()];
        // for(int i = 0; i<ans.length; i++){
        //     ans[i] = s.peek();
        //     s.pop();
        // }
        return s.stream()
                 .mapToInt(Integer::intValue)
                 .toArray();
    }
}