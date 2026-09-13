class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
              if(grid[i][j]==1){
                grid[i][j] = 0;
                max = Math.max(helper(grid,i,j,m,n),max);
              }
           }
        }

        return max;
        
    }


    private int helper(int[][] grid,int i,int j,int m,int n){
        if(i>=m || j>=n || i<0 || j<0){
            return 0;
        }

        int max = 1;
        if(i+1<m && grid[i+1][j]==1){
           grid[i+1][j] = 0;
           max += helper(grid,i+1,j,m,n); 
        }

        if(j+1<n && grid[i][j+1]==1){
            grid[i][j+1]=0;
           max += helper(grid,i,j+1,m,n); 
        }

        if(i-1>=0 && grid[i-1][j]==1){
           grid[i-1][j]=0;
           max += helper(grid,i-1,j,m,n); 
        }

        if(j-1>=0 && grid[i][j-1]==1){
           grid[i][j-1]=0;
           max += helper(grid,i,j-1,m,n); 
        }
        return max;
    }
}
