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
    public int minMeetingRooms(List<Interval> intervals) {
        int arr[] = new int[1000001];
        for(Interval interval : intervals){
            arr[interval.start]++;
            arr[interval.end]--;
        }

        int max = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
           sum += arr[i];
           max = Math.max(sum,max);
        }

        return max;

    }
}
