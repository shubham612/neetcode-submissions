class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        HashMap<Integer,List<Integer>> neibhMap = new HashMap<>();
        populateNeibhour(numCourses,prerequisites,neibhMap);

        boolean visited[] = new boolean[n];
        Queue<Integer> st = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                boolean recPath[] = new boolean[n];
                if(isCycleFound(i,visited,recPath,neibhMap,st)){
                   return new int[0];
                }
            }
        }
        int res[] = new int[n];
        int i = 0;
        while(!st.isEmpty()){
            res[i++] = st.poll();
        }

        return res;
    }

    private boolean isCycleFound(int curr,boolean[] visited,boolean[] recPath,HashMap<Integer,List<Integer>> neibhMap,Queue<Integer> st){
        visited[curr] = true;
        recPath[curr] = true;
        
        List<Integer> neibhours = neibhMap.getOrDefault(curr,null);
        if(neibhours!=null){
           for(Integer v : neibhours){
            if(!visited[v]){
                if(isCycleFound(v,visited,recPath,neibhMap,st)){
                    return true;
                }
            }else if(recPath[v]){
                return true;
            }
          }
        }
        st.offer(curr);
        recPath[curr] = false;
        return false;
    }

    private void populateNeibhour(int numCourses,int[][] prerequisites,HashMap<Integer,List<Integer>> neibhMap){
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v= prerequisites[i][1];
            if(neibhMap.containsKey(u)){
                List<Integer> neibhours = neibhMap.get(u);
                neibhours.add(v);
                neibhMap.put(u,neibhours);
            }else{
               List<Integer> neibhours = new ArrayList<>();
               neibhours.add(v);
               neibhMap.put(u,neibhours); 
            }
        }

    }
}
