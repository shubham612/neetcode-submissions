class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> valSt = new Stack<>();
        for(String token : tokens){
            if(isSymbol(token)){
                int a = Integer.parseInt(valSt.pop());
                int b = Integer.parseInt(valSt.pop());
                valSt.push(String.valueOf(operation(b,a,token)));

            }else{
                 valSt.push(token);
            }
        }

        return Integer.parseInt(valSt.pop());

    }

    private boolean isSymbol(String str){
        return (str.equals("+")|| str.equals("-") || str.equals("*") || str.equals("/"));
    }

    private int operation(int a,int b,String symbol){
        if(symbol.equals("+")){
            return a+b;
        }else if(symbol.equals("-")){
            return a-b;
        }else if(symbol.equals("*")){
            return a*b;
        }else{
            return a/b;
        }
    }
}
