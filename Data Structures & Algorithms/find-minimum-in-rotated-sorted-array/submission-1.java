class Solution {
    public int findMin(int[] nums) {
       return findMinHelper(nums,0,nums.length-1); 
    }

    private int findMinHelper(int[] nums,int si,int ei){
        if(si>=ei){
            return nums[si];
        }

        int midIndex = (si+ei)/2;
        int pre = nums[(midIndex-1+nums.length)%nums.length];
        int next = nums[(midIndex+1+nums.length)%nums.length];
        if(nums[midIndex]<=pre && nums[midIndex]<=ei){
            return nums[midIndex];
        }else if((nums[si]>nums[midIndex])|| (nums[si]<nums[midIndex]
         && nums[midIndex]<nums[ei])){
            return findMinHelper(nums,si,midIndex-1);
        }else{
            return findMinHelper(nums,midIndex+1,ei);
        }
    }
}
