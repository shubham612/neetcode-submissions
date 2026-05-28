class Solution {
    static class IndexTimeObj{
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
        int countOfFreshFruits = 0;
        Queue<IndexTimeObj> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                   IndexTimeObj newObj = new IndexTimeObj(i,j,0);
                   queue.offer(newObj); 
                }else if(grid[i][j]==1){
                   countOfFreshFruits++; 
                }
            }
        }

        if(countOfFreshFruits==0){
            return 0;
        }

        int minimumTime = 0;
        while(!queue.isEmpty()){
            IndexTimeObj currentNode = queue.poll();
            minimumTime = Math.max(minimumTime,currentNode.time);
            int i = currentNode.i;
            int j = currentNode.j;

            if(i-1>=0 && grid[i-1][j]==1){
                grid[i-1][j] = 2;
                queue.offer(new IndexTimeObj(i-1,j,currentNode.time+1));
                countOfFreshFruits--;
            } 

            if(j-1>=0 && grid[i][j-1]==1){
                grid[i][j-1] = 2;
                queue.offer(new IndexTimeObj(i,j-1,currentNode.time+1));
                countOfFreshFruits--;
            }

            if(i+1<grid.length && grid[i+1][j]==1){
                grid[i+1][j] = 2;
                queue.offer(new IndexTimeObj(i+1,j,currentNode.time+1));
                countOfFreshFruits--;
            }

            if(j+1<grid[0].length && grid[i][j+1]==1){
                grid[i][j+1] = 2;
                queue.offer(new IndexTimeObj(i,j+1,currentNode.time+1));
                countOfFreshFruits--;
            }

        }

        if(countOfFreshFruits>0){
            return -1;
        }else{
            return minimumTime;
        }


    }
}
