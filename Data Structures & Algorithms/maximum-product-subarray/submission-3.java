class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int max = nums[0];

        int j=1;
        while(j<nums.length){
            int op1 = nums[j];
            int op2 = nums[j] * currMin;
            int op3 = nums[j] * currMax;

            currMin = Math.min(op1,Math.min(op2,op3));
            currMax = Math.max(op1,Math.max(op2,op3));

            max = Math.max(max,currMax);
            j++;
        }

        return max;
    }

   
}
