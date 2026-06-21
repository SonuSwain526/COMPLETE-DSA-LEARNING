class RecentCounter {
    // Stack<Integer> s;
    Queue<Integer> q;
    public RecentCounter() {
        // s = new Stack<>();
        q = new LinkedList<>();
    }
    
    public int ping(int t) {

        q.offer(t);

        while(q.peek() < t - 3000){
            q.poll();
        }

        return q.size();
            }
        }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */