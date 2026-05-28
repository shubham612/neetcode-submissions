class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }

        HashMap<String,Integer> characterVsLastSeenMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right<s.length()){
            String currentCharacter = s.substring(right,right+1);
            if(characterVsLastSeenMap.containsKey(currentCharacter)){
                int lastSeenIndex = characterVsLastSeenMap.get(currentCharacter);
                if((lastSeenIndex+1)>left){
                    maxLength = Math.max(Math.abs(right-left),maxLength);
                    left = lastSeenIndex + 1;
                }
            }
            characterVsLastSeenMap.put(currentCharacter,right);
            right++;
        }

        maxLength = Math.max(Math.abs(right-left),maxLength);

        return maxLength;
    }
}
