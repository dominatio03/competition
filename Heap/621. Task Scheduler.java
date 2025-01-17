/*Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
Return the least number of units of times that the CPU will take to finish all the given tasks.

Example 1: Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.

Example 2: Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.

Example 3: Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : count) {
            if (i > 0) {
                heap.offer(i);
            }
        }
        
        int intervals = 0;
        while (!heap.isEmpty()) {
            int i = 0;
            List<Integer> next = new ArrayList<>();
            
            while (i <= n) {
                if (!heap.isEmpty()) {
                    if (heap.peek() > 1) {
                        next.add(heap.poll() - 1);
                    } else {
                        heap.poll();
                    }
                }
                i++;
                intervals++;
                if (heap.isEmpty() && next.size() == 0) {
                    break;
                }
            }
            
            for (int task : next) {
                heap.offer(task);
            }
        }
        return intervals;
    }
}// Sorting takes O(1) because length of the array is fixed.
//  So the overall time complexity is O(intervals).


