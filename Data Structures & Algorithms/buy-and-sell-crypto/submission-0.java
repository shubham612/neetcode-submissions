class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxElement = prices[prices.length-1];

        int i= prices.length-2;
        while(i>=0){
            int currentProfit = maxElement-prices[i];
            maxProfit = Math.max(maxProfit,currentProfit);
            maxElement = Math.max(maxElement,prices[i]);
            i--;
        }

        return maxProfit;
        
    }
}
