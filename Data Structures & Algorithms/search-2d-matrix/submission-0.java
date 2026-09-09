class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int arrayIndexForSearch = getArrayIndex(matrix,target);
        if(arrayIndexForSearch!=-1){
            if(matrix[arrayIndexForSearch][0]==target){
                return true;
            }else{
                return bs(matrix[arrayIndexForSearch],target);
            }
        }

        return false;
        
    }

    private boolean bs(int[] arr,int target){
        int si = 0;
        int ei = arr.length-1;

        while(si<=ei){
            int mid = (si+ei)/2;
            if(arr[mid]==target){
                return true;
            }

            if(target>arr[mid]){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }

        return false;
    }

    private int getArrayIndex(int[][] matrix,int target){
        int si = 0;
        int ei = matrix.length-1;

        int index = -1;

        while(si<=ei){
            int mid = (si+ei)/2;
            if(matrix[mid][0]==target){
                return mid;
            }

            if(matrix[mid][0]<target){
                index = mid;
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }

        return index;
    }
}
