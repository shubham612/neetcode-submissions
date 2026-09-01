class TimeMap {
    public static final String DEFAULT_VALUE = "";
    private class Node {
        int timeStamp;
        String value;

        Node(int timeStamp,String value){
          this.timeStamp = timeStamp;
          this.value = value;
        }
    }

    private Map<String,List<Node>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            List<Node> nodeList = map.get(key);
            nodeList.add(new Node(timestamp,value));
        }else{
            List<Node> nodeList = new ArrayList<>();
            nodeList.add(new Node(timestamp,value));
            map.put(key,nodeList);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
          return DEFAULT_VALUE;
        }
        return getNearestTimeStampValue(map.get(key),timestamp);
    }

    private String getNearestTimeStampValue(List<Node> nodeList,int timeStamp){
        int si = 0;
        int ei = nodeList.size()-1;
        int result = -1;

        while(si<=ei){
            int midIndex = (ei+si)/2;
            int midTimeStamp = nodeList.get(midIndex).timeStamp;
            if(midTimeStamp==timeStamp){
                return nodeList.get(midIndex).value;
            }

            if(midTimeStamp<timeStamp){
                result = midIndex;
                si = midIndex+1;
            }else{
                ei = midIndex-1;
            }
        }

        return result==-1 ? DEFAULT_VALUE : nodeList.get(result).value;
    }
}
