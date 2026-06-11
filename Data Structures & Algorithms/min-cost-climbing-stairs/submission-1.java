class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int dp[] = new int[cost.length+1];
        // for(int i=0;i<cost.length;i++){
        //     dp[i] = -1;
        // }
        // return Math.min(helper(cost,0,dp),helper(cost,1,dp));
        int dp[] = new int[cost.length+2];
        dp[dp.length-1] = 0;
        dp[dp.length-2] = 0;
        for(int i=cost.length-1;i>=0;i--){
            dp[i] = cost[i] + Math.min(dp[i+1],dp[i+2]);
        }

        return Math.min(dp[0],dp[1]);
    }

    private int helper(int[] cost,int index,int[] dp){
        if(index>=cost.length){
            return 0;
        }
        if(dp[index]==-1){
           dp[index] = cost[index]+Math.min(helper(cost,index+1,dp),helper(cost,index+2,dp));
        }
        return dp[index];
    }
}
