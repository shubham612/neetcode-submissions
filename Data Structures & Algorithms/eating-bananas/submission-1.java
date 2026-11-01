class Solution {
    /*
    Here main catch to derive maxSpeed at which koko can eat 
    banana(max element in the array) and least speed (1 b/hr)
    for each value lying between this range we need derive least value
    , at which speed can eat all banana within given (h hrs)
    */
    public int minEatingSpeed(int[] piles, int h) {
        int maxValueElement = getMaxElement(piles);
        return getMinSpeed(1,maxValueElement,piles,h);
    }

    private int getMaxElement(int[] piles){
        int maxValue = 0;
        for(int i=0;i<piles.length;i++){
           maxValue = Math.max(piles[i],maxValue);
        }
        return maxValue;
    }

    private int getMinSpeed(int low,int high,int[] piles,int h){
       int ans = -1;
       while(low<=high){
         int mid = low + (high-low)/2;
         if(canEat(piles,h,mid)){
            ans = mid;
            high = mid - 1;
         } else {
            low = mid + 1;
         }
       }
       return ans;
    }

    boolean canEat(int[] piles,int h,int val){
        long time=0;
        for(int i=0;i<piles.length;i++){
           long currPileTime = (long) (((long) piles[i] + val - 1) / val);
           // Use this formula for currentpileTime evaluation much easier to understand/memories as well : "(piles[i] / val + (piles[i] % val == 0 ? 0 : 1))"
           time+=currPileTime;
           if(time>h){
            return false;
           }
        }
        return true;
    }
}
