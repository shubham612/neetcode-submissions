class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] leftMul = new int[nums.length];
       int[] rightMul = new int[nums.length];
       int[] res = new int[nums.length];

       leftMul[0] = 1;
       rightMul[nums.length-1] = 1;

       for(int i=1;i<nums.length;i++){
         leftMul[i] = leftMul[i-1]*nums[i-1];
       }

       for(int i=nums.length-2;i>=0;i--){
         rightMul[i] = rightMul[i+1]*nums[i+1];
       }

       for(int i=0;i<nums.length;i++){
         res[i] = leftMul[i]*rightMul[i];
       }

       return res;
    }
}  
