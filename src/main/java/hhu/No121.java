package hhu;

public class No121 {
    public static void main(String args[]){
        int prices[] = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        for(int i = 0;i < prices.length;i++){
//            for(int j = i + 1;j < prices.length;j++){
//                if(prices[j] - prices[i] > max){
//                    max = prices[j] - prices[i];
//                }
//            }
//        }
//        return max;
//    }
    public static int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int minPrice = prices[0],maxProfit = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] > minPrice){
                int profit = prices[i] - minPrice;
                if(profit > maxProfit)
                    maxProfit = profit;
            }
            else
                minPrice = prices[i];
        }
        return maxProfit;
    }
}
