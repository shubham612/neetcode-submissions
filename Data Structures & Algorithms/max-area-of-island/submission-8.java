class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
              if(grid[i][j]==1){
                visited[i][j]=true;
                max = Math.max(helper(grid,i,j,m,n,visited),max);
              }
           }
        }

        return max;
        
    }


    private int helper(int[][] grid,int i,int j,int m,int n,boolean visited[][]){
        if(i>=m || j>=n || i<0 || j<0){
            return 0;
        }

        int max = 1;
        if(i+1<m && !visited[i+1][j] && grid[i+1][j]==1){
           visited[i+1][j] = true;
           max += helper(grid,i+1,j,m,n,visited); 
        }

        if(j+1<n && !visited[i][j+1] && grid[i][j+1]==1){
            visited[i][j+1]=true;
           max += helper(grid,i,j+1,m,n,visited); 
        }

        if(i-1>=0 && !visited[i-1][j] && grid[i-1][j]==1){
           visited[i-1][j]=true;
           max += helper(grid,i-1,j,m,n,visited); 
        }

        if(j-1>=0 && !visited[i][j-1] && grid[i][j-1]==1){
           visited[i][j-1]=true;
           max += helper(grid,i,j-1,m,n,visited); 
        }
        return max;
    }
}
