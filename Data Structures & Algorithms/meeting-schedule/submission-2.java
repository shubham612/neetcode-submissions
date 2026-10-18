/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
       if(intervals.size()<=1){
        return true;
       }
       intervals.sort((a, b) -> Integer.compare(a.start, b.start));
       int i = 0;
       int j = 1;
       while(j<intervals.size()){
         if(intervals.get(i).end>intervals.get(j).start){
            return false;
         }
         i++;
         j++;
       }

       return true;
    }
}
