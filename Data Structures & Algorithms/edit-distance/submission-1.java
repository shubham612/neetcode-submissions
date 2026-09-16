class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0] = i;
        }

        for(int j=1;j<=n;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],
                    Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        
        return dp[m][n];
        // return helper(word1,word2,m,n);
    }

    private int helper(String word1,String word2,int m,int n){
        if(m==0){
            return n;
        }else if(n==0){
            return m;
        }

        if(word1.charAt(m-1)==word2.charAt(n-1)){
            return helper(word1,word2,m-1,n-1);
        }else{
            return Math.min(helper(word1,word2,m,n-1),
            Math.min(helper(word1,word2,m-1,n),helper(word1,word2,m-1,n-1)))+1;
        }
    }
}
