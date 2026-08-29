class MinStack {

    List<Integer> s;
    List<Integer> mins;
    // int min = Integer.MAX_VALUE;

    public MinStack() {
        s = new ArrayList<>();
        mins = new ArrayList<>();
    }
    
    public void push(int value) {
        // min = Math.min(min, value);
        if (mins.size() < 1 || value <= mins.getLast()) mins.add(value);
        s.add(value);
    }
    
    public void pop() {
        if (s.size() < 1) return;
        if (s.getLast().equals(mins.getLast())) mins.removeLast();
        s.removeLast();
    }
    
    public int top() {
        return s.getLast();
    }
    
    public int getMin() {
        return mins.getLast();
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