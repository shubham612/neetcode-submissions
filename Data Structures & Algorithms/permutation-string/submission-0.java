class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        
        char[] charArray1 = s1.toCharArray();
        Arrays.sort(charArray1);
        String sorted1 = new String(charArray1);
        
        for(int i=s1.length()-1;i<s2.length();i++){
           String temp = s2.substring(i-s1.length()+1,i+1);
           char[] charArray = temp.toCharArray();
           Arrays.sort(charArray);
           String sorted2 = new String(charArray);
           if(sorted1.equals(sorted2)){
             return true;
           }

        }

        return false;
    }


}
