/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1: Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2: Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        int[] nums = new int[]{intervals[0][0], intervals[0][1]};
        for(int i=1 ; i<intervals.length ; i++) {
            int[] interval = intervals[i];
            if(interval[0]<=nums[1]) {
                nums[1] = Math.max(nums[1], interval[1]);
            } else {
                list.add(new int[]{nums[0], nums[1]});
                nums[0] = interval[0];
                nums[1] = interval[1];
            }
        }
        list.add(new int[]{nums[0], nums[1]});
        return list.toArray(new int[list.size()][2]);
} 

