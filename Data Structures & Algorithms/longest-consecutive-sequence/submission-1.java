class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            numSet.add(nums[i]);
        }
         
        int maxCount = 0;
        for(Integer currNum : numSet){
           if(!numSet.contains(currNum-1)){
             int currCount = 1;
             int ele = currNum;
             while(numSet.contains(ele+1)){
                currCount += 1;
                ele += 1;
             }
             maxCount = Integer.max(maxCount,currCount);
           }
        }

        return maxCount;
    }
}
