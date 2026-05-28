class Solution {

    class Pair {
        int num;
        int freq;

        Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
       }
    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq =new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
          pq.offer(new Pair(entry.getKey(),entry.getValue()));
          if (pq.size() > k) {
              pq.poll();
          }
        }

        int res[] = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
           res[index] = pq.poll().num;
           index++;
        }

        return res;
    }
}
