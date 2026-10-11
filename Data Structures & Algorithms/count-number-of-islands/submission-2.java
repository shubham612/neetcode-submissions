class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    grid[i][j] = '0';
                    helper(grid,i,j,m,n);
                    res++;
                }
            }
        }

        return res;
    }

    private void helper(char[][] grid,int i,int j,int m,int n){
        if(i>m || j>n || i<0 || j<0){
            return;
        }

        if(i+1<m && grid[i+1][j]=='1'){
           grid[i+1][j] = '0';
           helper(grid,i+1,j,m,n);
        }

        if(j+1<n && grid[i][j+1]=='1'){
           grid[i][j+1] = '0';
           helper(grid,i,j+1,m,n);
        }

        if(i-1>=0 && grid[i-1][j]=='1'){
           grid[i-1][j] = '0';
           helper(grid,i-1,j,m,n);
        }

        if(j-1>=0 && grid[i][j-1]=='1'){
           grid[i][j-1] = '0';
           helper(grid,i,j-1,m,n);
        }
    }
}
