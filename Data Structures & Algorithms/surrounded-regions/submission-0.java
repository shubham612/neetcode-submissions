class Solution {
    public void solve(char[][] board) {
       int m = board.length;
       int n = board[0].length;

       for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
            if(i==0 || j==0 || i==m-1 || j==n-1){
                if(board[i][j]=='O'){
                    board[i][j] = '#';
                    helper(board,i,j,m,n);
                }
            }
         }
       } 

       for(int i=0;i<board.length;i++){
         for(int j=0;j<board[0].length;j++){
            if(board[i][j]=='#'){
                board[i][j] = 'O';
            }else{
                board[i][j] = 'X';
            }
         }
       }     
    }

    private void helper(char[][] board,int i,int j,int m,int n){
        if(i>=m || j>=n || i<0 || j<0){
           return;
        }

        if(i+1<m && board[i+1][j]=='O'){
            board[i+1][j] = '#';
            helper(board,i+1,j,m,n);
        }

        if(i-1>=0 && board[i-1][j]=='O'){
            board[i-1][j] = '#';
            helper(board,i-1,j,m,n);
        }

        if(j+1<n && board[i][j+1]=='O'){
            board[i][j+1] = '#';
            helper(board,i,j+1,m,n);
        }

        if(j-1>=0 && board[i][j-1]=='O'){
            board[i][j-1] = '#';
            helper(board,i,j-1,m,n);
        }
    }
}
