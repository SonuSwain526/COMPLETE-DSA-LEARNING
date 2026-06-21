class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = costs[0];
        if(sum == coins) return 1;
        if(sum > coins) return 0;

        int c = 1;
        for( int i = 1; i < costs.length; i++){
            sum += costs[i];
            if(sum > coins) return c;
            c++;
        }
        return c;
    }
}