class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    char ch = board[i][j];
                    if((!seen.add(ch+"at row"+i)) 
                    || (!seen.add(ch+"at col"+j))
                    || (!seen.add(ch+"at block"+i/3+""+j/3))){
                        return false;
                    }
                }
            } 
        }

        return true;
    }
}
