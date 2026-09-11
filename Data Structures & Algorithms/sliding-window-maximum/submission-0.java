class Solution {
    public class Pair{
        int index;
        int value;

        public Pair(int index,int value){
            this.index = index;
            this.value = value;
        }
    }
    public int[] maxSlidingWindow(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.value-a.value);

        int i = 0;
        while(i<arr.length){
            if(i<k){
                pq.offer(new Pair(i,arr[i]));
                i++;
                continue;
            }
            while(pq.peek().index<i-k){
                pq.poll();
            }
            res.add(pq.peek().value);
            pq.offer(new Pair(i,arr[i]));
            i++;
        }

         while(pq.peek().index<i-k){
                pq.poll();
         }
        res.add(pq.peek().value);

        int[] resArr = res.stream().mapToInt(Integer::intValue)
                             .toArray();

        return resArr;
        
    }
}
