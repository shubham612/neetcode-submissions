class Solution {
    class Node{
        char ch;
        int freq;

        public Node(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    class Pair{
        Node node;
        int expiryTime;
        
        public Pair(Node node,int expiryTime){
           this.node = node;
           this.expiryTime = expiryTime;
        }
        
    }
    public int leastInterval(char[] tasks, int n) {
       PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(b.freq-a.freq));
       Queue<Pair> restQueue = new LinkedList<>();
       Map<Character,Integer> map = new HashMap<>();
       for(char ch : tasks){
         map.put(ch,map.getOrDefault(ch,0)+1);
        }

        map.forEach((key, value) -> {
            pq.offer(new Node(key,value));
        });

        int t = 0;
        while(!pq.isEmpty() || !restQueue.isEmpty()){
            if(!restQueue.isEmpty()){
                Pair curr = restQueue.peek();
                if(curr.expiryTime<t){
                    pq.offer(curr.node);
                    restQueue.poll();
                }
            }

            if(!pq.isEmpty()){
                Node toBeExecuted = pq.poll();
                int currFreq = toBeExecuted.freq-1;
                if(currFreq>0){
                    Node node = new Node(toBeExecuted.ch,currFreq);
                    restQueue.offer(new Pair(node,t+n));
                }
            }
            t++;
        }

        return t;
    }
}
