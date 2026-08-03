class Solution {
    public int change(int amount, int[] coins) {
        // return recursive(amount,coins,coins.length);
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }

        return dp[coins.length][amount];
    }

    private int recursive(int amount,int[] coins,int n){
        if(n==0){
            return amount==0 ? 1 : 0;
        }

        int notTake = recursive(amount,coins,n-1);
        int take = 0;
        if(coins[n-1]<=amount){
            take = recursive(amount-coins[n-1],coins,n);
        }

        return take + notTake;
    }
}
