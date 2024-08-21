/*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1: Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2: Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3: Input: nums = [1]
Output: [[1]]
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        List<Integer> subset = new ArrayList<>();
        toFindAllSubsets(nums, result, subset, 0);                
        
        return result;
    }
    
    private void toFindAllSubsets(int[] nums, List<List<Integer>> result, List<Integer> subset, int startIndex) {
        result.add(new ArrayList<>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            toFindAllSubsets(nums, result, subset, i + 1);
            subset.remove(subset.size() - 1);            
        }        
    }
}
// Time complexity: O(N * 2^N)
// Space complexity: O(N * 2^N)