class MyCircularQueue {
    int fr = 0;
    int ptr = 0;
    int size = 0;
    int[] q;
    public MyCircularQueue(int k) {
        q = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(size >= q.length) return false;
        q[ptr % q.length] = value;
        ptr++;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0) return false;
        fr++;
        size--;
        return true;
    }
    
    public int Rear() {
        if(size == 0) return -1;
        else return q[(ptr - 1 + q.length) % q.length];
    }
    
    public int Front() {
        if(size == 0) return -1;
        else return q[fr % q.length];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */