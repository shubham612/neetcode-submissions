class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
           dp[i] = -1;
        }


        return helper(s,0,dp);
    }

    private int helper(String s,int index,int[] dp){
        if(index==s.length()){
            return 1;
        }

        if(s.charAt(index)=='0'){
            return 0;
        }

        if(dp[index]==-1){
            int op1 = 0;
            int op2 = 0;
            if((index+1)<=s.length() &&
            Integer.valueOf(s.substring(index,index+1))<=26){
                op1 = helper(s,index+1,dp);
             }

            if((index+2)<=s.length() &&
            Integer.valueOf(s.substring(index,index+2))<=26){
                op2 = helper(s,index+2,dp);
            }
            dp[index] = op1+op2;
        }
        
        return dp[index];
    }
}
