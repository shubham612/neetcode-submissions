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
                if(i+1<j && heights[i+1]<heights[j-1]){
                    i++;
                }else{
                    j--;
                }
            }
        }
        return max;
    }
}
