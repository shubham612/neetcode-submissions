class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int i = 0;
        int j = heights.length-1;

        while(i<j){
            int heightCap = Math.min(heights[i],heights[j]);
            int capacity = heightCap*(j-i);
            max = Math.max(max,capacity);

            if(heights[i]<heights[j]){
                i++;
            }else if(heights[j]<heights[i]){
                j--;
            }else{
                i++;
            }
        }
        return max;
    }
}
