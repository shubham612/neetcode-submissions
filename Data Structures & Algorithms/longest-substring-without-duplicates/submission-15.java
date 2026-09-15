class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                int lastSeenIndex = map.get(ch);
                if(lastSeenIndex>=l){
                    int currlen = r - l;
                    max = Math.max(currlen,max);
                    l = lastSeenIndex + 1;
                }  
            }
            map.put(ch,r);
            r++;
        }

        return Math.max(r-l,max);
        
    }
}
