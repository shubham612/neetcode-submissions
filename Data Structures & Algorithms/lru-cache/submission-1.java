/**BRUTE_FORCE APPROACH 
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
**/

class LRUCache {
    public class Node{
      int key;
      int val;
      Node prev;
      Node next;

      public Node(int key,int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
      } 
    }
    private Node left;
    private Node right;
    private Map<Integer,Node> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.left = new Node(Integer.MIN_VALUE,-1);
        this.right = new Node(Integer.MAX_VALUE,-1);
        this.left.next = right;
        this.right.prev = left;
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    void insert(Node node){
        node.prev = right.prev;
        right.prev.next = node;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode = new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);
        if(cache.size()>capacity){
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
