class Solution {
    public int rob(int[] nums) {
        // int dp[] = new int[nums.length];
        // for(int i=0;i<dp.length;i++){
        //     dp[i] = -1;
        // }
        // return helper(nums,0,dp);

        int dp[] = new int[nums.length+2];
        dp[dp.length-1] = 0;
        dp[nums.length] = 0;
        for(int i=nums.length-1;i>=0;i--){
            dp[i] = Math.max(dp[i+1],nums[i]+dp[i+2]);
        }

        return Math.max(dp[0],dp[1]);
    }

    private int helper(int[] nums,int index,int dp[]){
        if(index>=nums.length){
            return 0;
        }

        if(dp[index]==-1){
            dp[index] = Math.max(helper(nums,index+1,dp),nums[index]+helper(nums,index+2,dp));
        }
        return dp[index];
    }
}
