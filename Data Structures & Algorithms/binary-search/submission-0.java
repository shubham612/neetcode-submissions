class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums,target,0,nums.length-1);
    }

    private int searchHelper(int[] nums,int target,int si,int ei){
        if(si>ei || si<0 || ei>=nums.length){
            return -1;
        }

        int midIndex = (si+ei)/2;
        if(nums[midIndex]==target){
            return midIndex;
        }

        if(nums[midIndex]>target){
            return searchHelper(nums,target,si,midIndex-1);
        }else{
            return searchHelper(nums,target,midIndex+1,ei);
        }
    }
}
