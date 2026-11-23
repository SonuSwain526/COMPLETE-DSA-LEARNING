class ProductOfNumbers {
    List<Integer> x;
    public ProductOfNumbers() {
        x = new ArrayList<>();
        x.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            x = new ArrayList<>();
            x.add(1);
        }else x.add(x.get(x.size() - 1) * num);
    }
    
    public int getProduct(int k) {
        if (k >= x.size()) return 0;
        return x.get(x.size() - 1) / x.get(x.size() - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */