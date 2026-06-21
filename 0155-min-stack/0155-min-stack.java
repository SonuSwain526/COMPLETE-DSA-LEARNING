class MinStack {
    MinStack x;
    int[] y;
    int ptr = -1;
    public MinStack() {
        y = new int[10];
    }
    
    public void push(int value) {
        if(ptr == y.length-1){
            int[] x = new int[2 * y.length];
            System.arraycopy(y, 0, x, 0, y.length);
            y = x;
        }
        ptr++;
        y[ptr] = value;
    }
    
    public void pop() {
        // if(isEmp()) ret
        ptr--;
    }
    
    public int top() {
        // int[] y = x;
        // int p = ptr;
        // int max = Integer.MIN_VALUE;
        // while(p != -1){
        //     max = Math.max(max, y[p]);
        //     p--;
        // }

        return y[ptr];
    }
    
    public int getMin() {
        int p = ptr;
        int max = Integer.MAX_VALUE;
        while(p != -1){
            max = Math.min(max, y[p]);
            p--;
        }

        return max;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */