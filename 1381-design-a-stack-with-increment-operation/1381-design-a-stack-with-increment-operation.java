class CustomStack {
    int ptr = -1;
    int[] s;

    public CustomStack(int maxSize) {
        s = new int[maxSize];
    }
    
    public void push(int x) {
        if(ptr >= s.length-1) return;
        ptr++;
        
        s[ptr] = x;
    }
    
    public int pop() {
        // int x = s[ptr];
        // ptr--;
        if(ptr <= -1) return -1;
        return s[ptr--];
    }
    
    public void increment(int k, int val) {
        if(k > ptr){
            for(int i = 0; i <= ptr; i++){
                s[i] += val;
            }
        }else{
            for(int i = 0; i < k; i++){
                s[i] += val;
            }
        }
        return;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */