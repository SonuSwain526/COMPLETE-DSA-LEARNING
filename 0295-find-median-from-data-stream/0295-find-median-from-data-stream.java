class MedianFinder {

    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;

    public MedianFinder() {
        minH = new PriorityQueue<>();
        maxH = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {

        // Decide which half
        if (maxH.isEmpty() || num <= maxH.peek()) {
            maxH.add(num);
        } else {
            minH.add(num);
        }

        // Balance
        if (maxH.size() > minH.size() + 1) {
            minH.add(maxH.poll());
        }

        if (minH.size() > maxH.size()) {
            maxH.add(minH.poll());
        }
    }
    
    public double findMedian() {

        if (maxH.size() > minH.size()) {
            return maxH.peek();
        }

        return ((double) maxH.peek() + minH.peek()) / 2.0;
    }
}