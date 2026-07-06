class Solution {
    public boolean canPartition(int[] nums) {
        int sum = sumOfArray(nums);
        if(sum%2==0){
          return targetSubSet(nums,sum/2);
        }else{
            return false;
        }
    }

    private int sumOfArray(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }

        return sum;
    }

    private boolean targetSubSet(int[] nums,int target){
         boolean[][] dp = new boolean[nums.length+1][target+1];

         // First column of table intialization
         for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
         }

        // First row of the table initialization
         for(int j=1;j<target+1;j++){
            dp[0][j] = false;
         }

         for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<target+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = (dp[i-1][j-nums[i-1]] || dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
         }

         return dp[nums.length][target];
    }
}
