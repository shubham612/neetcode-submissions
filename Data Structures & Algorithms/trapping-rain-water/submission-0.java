class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left[] = getNearestGreaterLeft(height);
        int right[] = getNearestGreaterRight(height);
        int trap = 0;
        for(int i=0;i<height.length;i++){
            int nearestLeft = left[i]==-1 ? 0 : height[left[i]];
            int nearestRight = right[i]==n ? 0 : height[right[i]];
           trap += Math.max(Math.min(nearestLeft,nearestRight)-height[i],0);
        }

        return trap;
    }

     private int[] getNearestGreaterLeft(int[] arr){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = -1;
                st.push(i);
            }else{
                res[i] = st.peek();
            }
            
        }

        return res;
    }

    private int[] getNearestGreaterRight(int[] arr){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = n;
                st.push(i);
            }else{
                res[i] = st.peek();
            }   
        }
        return res;
    } 
}
