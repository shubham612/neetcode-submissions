class Solution {
    public int characterReplacement(String s, int k) {
       int left = 0;
       int right = 0;
       int maxLen = 0;
       int maxFreq = 0;
       int[] freq = new int[26];
       while(right<s.length()){
           int len = right - left + 1;
           int currentIndex = s.charAt(right)-'A';
           freq[currentIndex] = freq[currentIndex]+1;
           maxFreq = Math.max(maxFreq,freq[currentIndex]);
           if(len - maxFreq > k){
              int leftIndex = s.charAt(left)-'A'; 
              freq[leftIndex] = freq[leftIndex]-1;
            //   maxLen = Math.max(len-1,maxLen);
              left++;
           }
           right++;
       }

       maxLen = right - left;

       return maxLen;
    }
}
