class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String key = createKey(strs[i]);
            if(map.containsKey(key)){
               List<String> value = map.get(key);
               value.add(strs[i]);
            }else{
               List<String> newList = new ArrayList<>();
               newList.add(strs[i]);
               map.put(key,newList);
            }
        }

        for (List<String> value : map.values()) {
            res.add(value);
        }

        return res;

    }

    private String createKey(String str){
        String key="";
        int[] charFreq = new int[256];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int index = (int) ch-1;
            charFreq[index]++;
        }
        for(int i=0;i<256;i++){
           char ch = (char) (i+1);
           key = key + "" + ch + "" + charFreq[i];
        }

        return key;
    }
}
