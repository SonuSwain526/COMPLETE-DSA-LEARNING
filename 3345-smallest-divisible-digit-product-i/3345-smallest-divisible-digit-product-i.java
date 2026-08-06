class Solution {
    public int smallestNumber(int n, int t) {
        
        boolean b = true;

        while (b) {

            int x = n;
            int sum = 1;
            while (x > 0){
                sum *= x % 10;
                x = x / 10;
            }

            // System.out.println(sum);

            // if (sum == 0) return n;

            if (sum % t == 0) {
                return n;
            }
            n++;
        }

        return 0;
    }
}