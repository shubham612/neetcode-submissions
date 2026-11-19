class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return helper(nums,0);
    }

    private List<List<Integer>> helper(int[] nums,int index){
        if(index==nums.length){
            List<Integer> emptyList = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            res.add(emptyList);
            return res;
        }
        
        List<List<Integer>> temp = helper(nums,index+1);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> eleList : temp){
            res.add(eleList);
            List<Integer> appendedList = new ArrayList<>();
            appendedList.add(nums[index]);
            for(Integer ele : eleList){
              appendedList.add(ele);
            }
            res.add(appendedList);
        }

        return res;
    }
}
