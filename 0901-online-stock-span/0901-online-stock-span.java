class StockSpanner {
    ArrayList<Integer> days;
    ArrayList<Integer> pge = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    public StockSpanner() {
        days = new ArrayList<>();
    }
    
    public int next(int price) {
        days.add(price);
        while(!s.isEmpty() && days.get(s.peek()) <= price){
            s.pop();
        }

        if(s.isEmpty()) pge.add(-1);
        else pge.add(s.peek());
        s.push(days.size()-1);

        if(pge.getLast() == -1) return days.size();
        else return pge.size() - pge.getLast()-1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */