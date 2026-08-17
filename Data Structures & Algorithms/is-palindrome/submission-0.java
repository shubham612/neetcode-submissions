class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i<=j){
            int asciiValueOfIthChar = (int) s.charAt(i);
            if(!isValidAsciiValue(asciiValueOfIthChar)){
                i++;
                continue;
            }

            if(asciiValueOfIthChar>=97){
               asciiValueOfIthChar = 65 + (asciiValueOfIthChar-97);  
            }

            int asciiValueOfJthChar = (int) s.charAt(j);
            if(!isValidAsciiValue(asciiValueOfJthChar)){
               j--;
               continue;
            }

            if(asciiValueOfJthChar>=97){
              asciiValueOfJthChar = 65 + (asciiValueOfJthChar-97);
            }

            if(asciiValueOfIthChar==asciiValueOfJthChar){
                i++;
                j--;
            }else{
                return false;
            }
        }

        return true;
    }

    private boolean isValidAsciiValue(int val){
        if((val>=48 && val<=57) || (val>=65 && val<=90) || (val>=97 &&  val<=122)){
            return true;
        }

        return false;
    }
}
