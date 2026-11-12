class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int res[] = new int[2];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                int indexVal = map.get(target-nums[i]);
                if(indexVal!=i){
                   if(indexVal<i){
                     res[0] = indexVal;
                     res[1] = i;
                   }else{
                     res[1] = indexVal;
                     res[0] = i;
                   }
                }
                
            }
        }

        return res;
    }
}
