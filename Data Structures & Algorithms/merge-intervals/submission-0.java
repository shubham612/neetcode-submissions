class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        int i = 1;
        while(i<intervals.length){
           int[] lastMerged = result.get(result.size()-1);
           int currStartEle = intervals[i][0];
           int lastMergedEndEle = lastMerged[1];
           if(lastMergedEndEle>=currStartEle){
             lastMerged[1] = Math.max(intervals[i][1],lastMergedEndEle);
           }else{
            result.add(intervals[i]);
           }
           i++;
        }

        return result.toArray(new int[result.size()][]);

    }
}
