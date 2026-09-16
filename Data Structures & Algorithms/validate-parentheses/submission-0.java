class Solution {
    public boolean isValid(String s) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
           String bracket = s.substring(i,i+1);
           if(isClosingBracket(bracket)){
              if(!st.isEmpty() && isMatchingPair(bracket,st.peek())){
                st.pop();
              }else{
                return false;
              }
           }else{
            st.push(bracket);
           }
        }

        return st.isEmpty();
    }

    private boolean isClosingBracket(String str){
        return str.equals("]") || str.equals("}") || str.equals(")");
    }

    private boolean isMatchingPair(String str1,String str2){
        return (str1.equals("}") && str2.equals("{"))
        || (str1.equals("]") && str2.equals("["))
        || (str1.equals(")") && str2.equals("("));
    }
}
