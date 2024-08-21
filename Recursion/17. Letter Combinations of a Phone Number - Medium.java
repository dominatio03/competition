/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.A mapping of digits to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example 1: Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2: Input: digits = ""
Output: []

Example 3: Input: digits = "2"
Output: ["a","b","c"]
 */

class Solution {
    public List<String> letterCombinations(String digits) {      
      String[] m = new String[]{" ", 
                                "", 
                                "abc", 
                                "def",
                                "ghi",
                                "jkl",
                                "mno",
                                "pqr",
                                "stuv",
                                "wxyz"};        
      char[] cur = new char[digits.length()];
      List<String> answer = new ArrayList<>();
      dfs(digits, m, 0, cur, answer);
      return answer;
    }
    private void dfs(String digits, String[] m, 
                     int l, char[] cur, List<String> answer) {
      if (l == digits.length()) {
          if (l > 0) answer.add(new String(cur));
          return;
      }
 
      String s = d[Character.getNumericValue(digits.charAt(l))];
 
      for (int i = 0; i < s.length(); ++i) {
          cur[l] = s.charAt(i);
          dfs(digits, m, l + 1, cur, answer);            
      }
    }
} // I have used DFS because it takes less time then BFS.

