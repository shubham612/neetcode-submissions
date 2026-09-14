class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        HashMap<Integer,List<Integer>> neibhMap = new HashMap<>();
        populateNeibhour(numCourses,prerequisites,neibhMap);

        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                boolean recPath[] = new boolean[n];
                if(isCycleFound(i,visited,recPath,neibhMap)){
                   return false;
                }
            }
        }

        return true;
        
    }

    private boolean isCycleFound(int curr,boolean[] visited,boolean[] recPath,HashMap<Integer,List<Integer>> neibhMap){
        visited[curr] = true;
        recPath[curr] = true;
        
        List<Integer> neibhours = neibhMap.getOrDefault(curr,null);
        if(neibhours!=null){
           for(Integer v : neibhours){
            if(!visited[v]){
                if(isCycleFound(v,visited,recPath,neibhMap)){
                    return true;
                }
            }else if(recPath[v]){
                return true;
            }
          }
        }
        
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
