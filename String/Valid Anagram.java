/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1: Input: s = "anagram", t = "nagaram"
Output: true

Example 2: Input: s = "rat", t = "car"
Output: false
 */

class Solution {
    public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) {
        return false;
    }
    Map<Character,Integer> sMap = new HashMap<>();
        
    for(int i = 0; i < s.length(); i++) {
        sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        sMap.put(t.charAt(i), sMap.getOrDefault(t.charAt(i), 0) - 1);
    }
        
    for(char c : sMap.keySet()) {
        if(sMap.get(c) != 0) {
            return false;    
        }
    }
        
    return true;
}
} // Time: O(n), Space: O(n)

