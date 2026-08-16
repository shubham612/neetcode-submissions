class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    int L = s.length();
    boolean[] dp = new boolean[L + 1];
    dp[0] = true;  // empty prefix is trivially "breakable"

    for (int i = 1; i <= L; i++) {
        for (String w : wordDict) {
            int k = w.length();
            if (k <= i && dp[i - k] && s.substring(i - k, i).equals(w)) {
                dp[i] = true;
                break;  // no need to check other words once dp[i] is true
            }
        }
    }
    return dp[L];

    }


    boolean fun(String word, List<String> wordDict) {
    if (word.isEmpty()) {
        return true;
    }
    boolean res = false;
    for (int i = 0; i < wordDict.size(); i++) {
        String w = wordDict.get(i);
        if(w.length()<=word.length()){
            if(word.endsWith(w)){
                boolean temp = fun(word.substring(0, word.length() - w.length()),wordDict);
                res = res || temp;
                if(res==true){
                   break;
                }
            }
            
        }
        
    }
    return res;

    }

    
}
