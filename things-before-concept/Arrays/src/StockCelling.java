public class StockCelling {
    public static void main(String[] args) {
        int[] prices = {4,3,2,8,1};
        int profit = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int x: prices){
            if (x < min){
                min = x;
            }
            else
                profit = Math.max(profit, x-min);
        }
        System.out.println(profit);
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i+1; j < prices.length; j++) {
//                if(prices[i] < prices[j] && prices[j] - prices[i] > profit){
//                    profit = prices[j] - prices[i];
//                }
//            }
//        }
//        System.out.println(profit);
    }
}
