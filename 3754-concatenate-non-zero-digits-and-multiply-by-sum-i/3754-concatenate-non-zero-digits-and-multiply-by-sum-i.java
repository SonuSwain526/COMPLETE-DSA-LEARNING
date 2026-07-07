class Solution {
    public long sumAndMultiply(int n) {
        // StringBuilder sb = new StringBuilder();

        Stack<Integer> s = new Stack<>();

        while(n > 0){
            if(n % 10 != 0)
                s.push(n % 10);
            n = n / 10;
        }
        int sum = 0;
        int x = 0;

        while(!s.isEmpty()){
            sum += s.peek();
            x += (int)(s.peek() * Math.pow(10, s.size()-1));
            s.pop();
        }

        long ans = (long) sum * x;

        return ans;
    }
}