class FrontMiddleBackQueue {
    LinkedList<Integer> list;
    public FrontMiddleBackQueue() {
        // initialize it
        list = new LinkedList<>();
    }

    public void pushFront(int val) {
        // add at the 0th index or at Head
        list.add(0, val);

        
    }

    public void pushMiddle(int val) {
        // push at the middle index
        list.add(list.size() / 2, val);
    }

    public void pushBack(int val) {
        // add at tail
        list.add(val);
    }

    public int popFront() {
        if (list.isEmpty()) {
            return -1;
        }
        // use removeFirst
        return list.removeFirst();
    }

    public int popMiddle() {
        if (list.isEmpty()) {
            return -1;
        }
        // remove the element at the mid index
        return list.remove(findMid());
    }

    public int popBack() {
        if (list.isEmpty()) {
            return -1;
        }
         // use removeLast
        return list.removeLast();
    }

    public int findMid() {
        // give the middle index 
        return (list.size() - 1) / 2;
    }
	// Don't FORGET TO UPVOTE , THANKS
}