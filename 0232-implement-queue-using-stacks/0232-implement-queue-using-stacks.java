class MyQueue {
    Stack<Integer> s;
    public MyQueue() {
        s = new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
    }
    
    public int pop() {
        if (s.isEmpty()) return -1;
        if (s.size() == 1) return s.pop();
        Stack<Integer> x = new Stack<>();
        int ans = 0;
        while(!s.isEmpty()) {
            if (s.size() == 1){
                ans = s.pop();
                continue;
            } 
            x.push(s.peek());
            s.pop();
        }
        while (!x.isEmpty()) s.push(x.pop());
        // Collections.reverse(x);
        // for (int e: x) s.push(e);
        return ans;
    }
    
    public int peek() {
        if (s.isEmpty()) return -1;
        if (s.size() == 1) return s.peek();
        Stack<Integer> x = new Stack<>();
        int ans = 0;
        while(!s.isEmpty()) {
            if (s.size() == 1){
                ans = s.peek();
            } 
            x.push(s.peek());
            s.pop();
        }
        while (!x.isEmpty()) s.push(x.pop());
        // for (int i = x.size() - 1; i >= 0; i--) s.push(x.get(i));

        // Collections.reverse(x);
        // for (int e: x) s.push(e);
        return ans;
    }
    
    public boolean empty() {
        return s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */