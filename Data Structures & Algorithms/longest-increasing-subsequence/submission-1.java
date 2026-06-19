class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                   dp[i][j] = -1;
            }
        }
        return helper(nums,0,-1,dp);
    }

    private int helper(int[] nums,int index,int prevIndex,int[][] dp){
        if(index==nums.length){
            return 0;
        }

        if(dp[index][prevIndex+1]!=-1){
           return dp[index][prevIndex+1]; 
        }
        int notTake = helper(nums,index+1,prevIndex,dp);
        int take = 0;
        if(prevIndex==-1 || nums[prevIndex]<nums[index]){
            take = 1 + helper(nums,index+1,index,dp);
        }

        dp[index][prevIndex+1] = Math.max(take,notTake);
        return dp[index][prevIndex+1];
    }
}
