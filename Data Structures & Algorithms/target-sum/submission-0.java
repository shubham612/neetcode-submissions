class Solution {
    int m = 0;
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
       int total = 0;

        for (int x : nums)
            total += x;

        if (Math.abs(target) > total)
            return 0;

        if ((target + total) % 2 != 0)
            return 0;

        int required = (target + total) / 2;

        int[] dp = new int[required + 1];

        dp[0] = 1;

        for (int num : nums) {

            // Traverse backwards to avoid reusing the same element
            for (int sum = required; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }

        return dp[required]; 
    }

    private int helper(int nums[],int target,int n){
        if(target > m || target < -m)
            return 0;

        if(n==0){
            return target==0 ? 1 : 0;
        }
        if(dp[n][target+m]==Integer.MIN_VALUE){
            dp[n][target+m] = helper(nums,target-nums[n-1],n-1) 
            + helper(nums,target+nums[n-1],n-1);
        }

        return dp[n][target+m];
    }
}
