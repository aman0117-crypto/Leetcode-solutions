class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            minPrice=Math.min(prices[i],minPrice);
            int profit=prices[i]-minPrice;
            maxProfit=Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}