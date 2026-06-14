class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }

        int[] temp1 = new int[nums.length-1];
        int[] temp2 = new int[nums.length-1];
        int j=0;
        int k=0;
        for(int i=0;i<nums.length;i++){
           if(i!=0){
              temp1[j++] = nums[i];
           }

           if(i!=nums.length-1){
            temp2[k++] = nums[i];
           }
        }

        return Math.max(getMax(temp1),getMax(temp2));
    }

    public int getMax(int[] nums) {
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

}
