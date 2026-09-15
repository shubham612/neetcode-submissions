class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> freqMap = new HashMap<>();
        getFrequencyMap(freqMap,t);
        int count = freqMap.size();
        String res = "";
        int i = 0;
        int j = 0;
        while(j<s.length()){
            if(count==0){
               while(count==0 && i<j){
                 Character ch = s.charAt(i);
                 if(freqMap.containsKey(ch)){
                     int value = freqMap.get(ch);
                     if(value==0){
                        String temp = s.substring(i,j);
                        if(res.isEmpty() || temp.length()<res.length()){
                            res = temp;
                        }
                     }

                    value++;
                    freqMap.put(ch,value);
                    if(value>0){
                      count++;
                    }   
                 }
                 i++;
                 
               }
            }

            Character ch = s.charAt(j);
            if(freqMap.containsKey(ch)){
                int value = freqMap.get(ch);
                value--;
                freqMap.put(ch,value);
                if(value==0){
                    count--;
                }
            }
            j++;
        }

         if(count==0){
               while(count==0 && i<j){
                 Character ch = s.charAt(i);
                 if(freqMap.containsKey(ch)){
                     int value = freqMap.get(ch);
                     if(value==0){
                        String temp = s.substring(i,j);
                        if(res.isEmpty() || temp.length()<res.length()){
                            res = temp;
                        }
                     }

                    value++;
                    freqMap.put(ch,value);
                    if(value>0){
                      count++;
                    }   
                 }
                 i++;
                 
               }
        }

        return res; 
    }

    private void getFrequencyMap(Map<Character,Integer> freqMap,String str){
        for(int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
    }
}
