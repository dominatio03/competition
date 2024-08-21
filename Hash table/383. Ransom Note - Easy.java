/*Given two strings ransomNote and magazine,
return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1: Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:  Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3: Input: ransomNote = "aa", magazine = "aab"
Output: true
*/
class Solution {
    public:
     bool canConstruct(string ransomNote, string magazine) {
       vector<int> count(128);
   
       for (const char t : magazine)
         ++count[t];
   
       for (const char t : ransomNote)
         if (--count[t] < 0)
           return false;
   
       return true;
     }
   };
/*
Time: O(ransomNote + magazine)
Space: (128) = O(1)
*/