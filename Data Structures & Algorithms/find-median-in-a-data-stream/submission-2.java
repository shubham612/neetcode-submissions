class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);                   
        minHeap.offer(maxHeap.poll());         
    
        if (minHeap.size() > maxHeap.size()) { 
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(!maxHeap.isEmpty() || !minHeap.isEmpty()){
            if((!maxHeap.isEmpty() && !minHeap.isEmpty()) && (maxHeap.size()==minHeap.size())){
                 double res = (maxHeap.peek()+minHeap.peek())/2.0;
                 return res;
            }else{
               return maxHeap.peek();
            }
        }
        return 0.0;
        
    }
}
