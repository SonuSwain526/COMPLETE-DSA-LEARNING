class KthLargest {

    PriorityQueue<Integer> mh ;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        mh = new PriorityQueue<>();
        // for (int elem: nums) mh.add(elem);

        Arrays.sort(nums);

        int i = nums.length - 1;

        while (mh.size() < k && i >= 0) {mh.add(nums[i]); i--; }

        // for (int i = 1; i <= k; i++){
        //     mh.poll();
        // }
    }
    
    public int add(int val) {
        if (mh.isEmpty()) mh.add(val);
        else if (val >= mh.peek() && k >= mh.size()) { if (k == mh.size()) {mh.poll();} mh.add(val); }

        if ( val < mh.peek() && k > mh.size()) mh.add(val);

        if (mh.isEmpty()) return 0;

        return mh.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */