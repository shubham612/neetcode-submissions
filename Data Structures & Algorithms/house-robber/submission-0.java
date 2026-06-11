class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        return helper(nums,0,dp);
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
