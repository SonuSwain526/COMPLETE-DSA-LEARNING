class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int mul = 1;
        int o = n;
        while(n > 0) {
            sum += n % 10;
            mul *= n % 10;
            n = n / 10;
        }
        return (o % (sum + mul) == 0);
    }
}