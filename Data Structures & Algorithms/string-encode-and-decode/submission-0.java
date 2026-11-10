class Solution {

    public String encode(List<String> strs) {
      String encoded = "";
      for(String str : strs){
        String delimiter = str.length()+"#";
        encoded = encoded + "" + delimiter + "" + str;
      }
      return encoded;
    }

    public List<String> decode(String str) {
        List<String> decodeStr = new ArrayList<>();
        int i =0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#' && j<str.length()){
                j++;
            }
            int currLen = Integer.valueOf(str.substring(i,j));
            decodeStr.add(str.substring(j+1,j+currLen+1));
            i = j+currLen+1;
        }

        return decodeStr;
    }
}
