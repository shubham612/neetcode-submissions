class Solution {
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        int m = num1.length;
        int n = num2.length;
        if(m>n){
            int[] temp = num1;
            num1 = num2;
            num2 = temp;

            int temp1 = m;
            m = n;
            n = temp1;
        }
        

        int i = indexOfPartion(num1,num2,m,n);
        int j = (m+n+1)/2-i;
        int aLeftMax = (i == 0) ? Integer.MIN_VALUE : num1[i - 1];
        int aRightMin = i==m ? Integer.MAX_VALUE : num1[i];
        int bLeftMax = (j == 0) ? Integer.MIN_VALUE : num2[j - 1];
        int bRightMin = j==n ? Integer.MAX_VALUE : num2[j];

        int maxLeft = Math.max(aLeftMax, bLeftMax);
        int minRight = Math.min(aRightMin, bRightMin);
        double res = 0.0;
        if((m+n)%2==0){
           res = (maxLeft+minRight)/2.0;
        }else{
           res = maxLeft*(1.0); 
        }

        return res;
    }


    private int indexOfPartion(int[] num1,int[] num2,int m,int n){
        int low = 0;
        int high = m;

        while(low<=high){
            int i = (low+high)/2;
            int j = (m+n+1)/2-i;

            int aLeftMax = (i == 0) ? Integer.MIN_VALUE : num1[i - 1];
            int aRightMin = i==m ? Integer.MAX_VALUE : num1[i];
            int bLeftMax = (j == 0) ? Integer.MIN_VALUE : num2[j - 1];
            int bRightMin = j==n ? Integer.MAX_VALUE : num2[j];
            
            if(aLeftMax>bRightMin){
                high = i-1;
            }else if (bLeftMax>aRightMin){
                low = i+1;
            }else{
                return i;
            }
        }

        return -1;

    }
}
