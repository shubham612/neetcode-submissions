class Solution {
    class Pair{
        int[] point;
        double distance;

        public Pair(int[] point,double distance){
            this.point = point;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->Double.compare(b.distance, a.distance));
        int[][] res = new int[k][2];
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            
            double dist = Math.sqrt(x*x + y*y);
            pq.offer(new Pair(points[i],dist));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int j = 0;
        while(!pq.isEmpty()){
           int[] temp = pq.poll().point;
           res[j][0] = temp[0];
           res[j][1] = temp[1];
           j++;
        }

        return res;
    }


}
