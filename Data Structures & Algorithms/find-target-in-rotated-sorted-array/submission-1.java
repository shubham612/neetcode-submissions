class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums,0,nums.length-1,target);
    }


    private int searchHelper(int[] nums,int si,int ei,int target){
        if(ei<si){
            return -1;
        }

        int mid = si + (ei-si)/2;
        if(nums[mid]==target){
            return mid;
        }

        if(nums[si]<=nums[mid]){
            if(nums[si]<=target && target<=nums[mid]){
                return searchHelper(nums,si,mid-1,target);
            }else{
                return searchHelper(nums,mid+1,ei,target);
            }
        }else{
            if(nums[mid]<=target && target<=nums[ei]){
                return searchHelper(nums,mid+1,ei,target);
            }else{
               return searchHelper(nums,si,mid-1,target); 
            }
        }
    }
}
