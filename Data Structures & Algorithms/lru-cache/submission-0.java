class LRUCache {
    public class Pair{
        int key;
        int val;

        public Pair(int key,int value){
            this.key = key;
            this.val = value;
        }
    }
    List<Pair> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.cache = new ArrayList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        for(int i=0;i<cache.size();i++){
            if(cache.get(i).key==key){
                int val = cache.get(i).val;
                cache.remove(i);
                cache.add(new Pair(key,val));
                return val;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
       for(int i=0;i<cache.size();i++){
          if(cache.get(i).key==key){
            cache.remove(i);
            cache.add(new Pair(key,value));
            return;
          }
       }
       cache.add(new Pair(key,value));
       if(cache.size()>capacity){
         cache.remove(0);
       }
    }
}
