class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<0){
            return -1;
        }

        int[] dp = new int[amount+1];
        for(int i=1;i<dp.length;i++){
            dp[i] = Integer.MIN_VALUE;
        }

        return helper(coins,amount,dp);
    }

    private int helper(int coins[],int amount,int[] dp){
        if(amount==0){
            return dp[0];
        }else if(amount<0){
            return -1;
        }
        
        if(dp[amount]==Integer.MIN_VALUE){
           int res = Integer.MAX_VALUE;
           for(int i=0;i<coins.length;i++){
               int temp = helper(coins,amount-coins[i],dp);
               if(temp!=-1){
                  res = Math.min(res,1+temp);
                }
            }

             dp[amount] = (res==Integer.MAX_VALUE) ? -1 : res;
        }
       return dp[amount];
    }
}
