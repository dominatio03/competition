/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
 
    int[] t1 = new int[nums.length];
    int[] t2 = new int[nums.length];
 
    t1[0]=1;
    t2[nums.length-1]=1;
 
    //scan from left to right
    for(int i=0; i<nums.length-1; i++){
        t1[i+1] = nums[i] * t1[i];
    }
 
    //scan from right to left
    for(int i=nums.length-1; i>0; i--){
        t2[i-1] = t2[i] * nums[i];
    }
 
    //multiply
    for(int i=0; i<nums.length; i++){
        result[i] = t1[i] * t2[i];
    }
 
    return result;
}
}

