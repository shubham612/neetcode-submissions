class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int k=0;k<nums.length-2;k++){
            if(k>0 && nums[k]==nums[k-1]){
                continue;
            }
            int target = 0-nums[k];
            int i = k+1;
            int j = nums.length-1;

            while(i<j){
                int sum = nums[i]+nums[j];
                if(sum<target){
                  i++;
                }else if(sum>target){
                  j--;
                }else{
                  List<Integer> comb = new ArrayList<>();
                  comb.add(nums[k]);
                  comb.add(nums[i]);
                  comb.add(nums[j]);
                  res.add(comb);
                  while(i<j && nums[i]==nums[i+1]){
                     i++;
                  }

                  while(i<j && nums[j]==nums[j-1]){
                    j--;
                  }
                 
                  i++;
                  j--;
                }  
            }
        }

        return res;
    }
}
