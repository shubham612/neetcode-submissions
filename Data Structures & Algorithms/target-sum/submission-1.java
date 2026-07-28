class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        for (int x : nums)
            total += x;

        if (Math.abs(target) > total)
            return 0;

        if ((target + total) % 2 != 0)
            return 0;

        int required = (target + total) / 2;

        int[][] dp = new int[nums.length + 1][required + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {

            int num = nums[i - 1];

            for (int sum = 0; sum <= required; sum++) {

                // Don't take current number
                dp[i][sum] = dp[i - 1][sum];

                // Take current number
                if (sum >= num)
                    dp[i][sum] += dp[i - 1][sum - num];
            }
        }

        return dp[nums.length][required];
    }
}