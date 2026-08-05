class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return recursiveApproach(text1,text2,text1.length(),text2.length());
        
        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                   dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                   dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    private int recursiveApproach(String text1,String text2,int m,int n){
         if(m==0 || n==0){
            return 0;
         }

         if(text1.charAt(m-1)==text2.charAt(n-1)){
            return 1 + recursiveApproach(text1,text2,m-1,n-1);
         }else{
            return Math.max(recursiveApproach(text1,text2,m,n-1),
            recursiveApproach(text1,text2,m-1,n));
         }
    }
}
