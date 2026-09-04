class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = getNearestSmallerLeft(heights);
        int[] right = getNearestSmallerRight(heights);

        int max = 0;
        for(int i=0;i<heights.length;i++){
            int area = (right[i]-left[i]-1)*heights[i];
            max = Math.max(area,max);
        }

        return max;
    }

    private int[] getNearestSmallerLeft(int[] arr){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
        }

        return res;
    }

    private int[] getNearestSmallerRight(int[] arr){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = n;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
}
