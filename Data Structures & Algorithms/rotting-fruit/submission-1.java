class Solution {
    class IndexTimeObj{
        int i;
        int j;
        int time;

        public IndexTimeObj(int i,int j,int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<IndexTimeObj> queue = new LinkedList<>();
        int numofFreshOrganges = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                   queue.offer(new IndexTimeObj(i,j,0));
                }else if(grid[i][j]==1){
                  numofFreshOrganges++;
                }
            }
        }
        if(numofFreshOrganges==0){
            return 0;
        }

        int minTime = 0;
        while(!queue.isEmpty()){
           IndexTimeObj curr = queue.poll();
           int i = curr.i;
           int j = curr.j;
           minTime = Math.max(minTime,curr.time);

           if(i+1<m && grid[i+1][j]==1){
             grid[i+1][j]=2;
             queue.offer(new IndexTimeObj(i+1,j,curr.time+1));
             numofFreshOrganges--;
           }

           if(j+1<n && grid[i][j+1]==1){
             grid[i][j+1]=2;
             queue.offer(new IndexTimeObj(i,j+1,curr.time+1));
             numofFreshOrganges--; 
           }


           if(i-1>=0 && grid[i-1][j]==1){
             grid[i-1][j]=2;
             queue.offer(new IndexTimeObj(i-1,j,curr.time+1));
             numofFreshOrganges--; 
           }

           if(j-1>=0 && grid[i][j-1]==1){
             grid[i][j-1]=2;
             queue.offer(new IndexTimeObj(i,j-1,curr.time+1));
             numofFreshOrganges--;
           }
        }

        if(numofFreshOrganges!=0){
            return -1;
        }else{
            return minTime;
        }
        
    }
}
