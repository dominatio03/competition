/*Given a string s and a dictionary of strings wordDict, 
return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class Solution {
    public boolean wordBreak(String a, Set<String> dict) {
        boolean[] t = new boolean[a.length()+1];
        t[0] = true;
        for(int i=0; i<a.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
            for(String c: dict){
                int len = c.length();
                int end = i + len;
                if(end > a.length())
                    continue;
                if(t[end]) continue;
                if(a.substring(i, end).equals(c)){
                    t[end] = true;
                }
            }
        }
        return t[a.length()];
    }
} // Time: O(string length * dictionary size).

 //if the size of the dictionary is very large, the time might be too long. Instead problem can be solved in O(n^2) time.
public class Solution {
    public boolean wordBreak(String a, Set<String> wordDict) {
        int[] pos = new int[a.length()+1];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        for(int i=0; i< a.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=a.length(); j++){
                    String substr = a.substring(i, j);
                    if(wordDict.contains(substr)){
                        pos[j]=i;
                    }
                }
            }
        }
        return pos[a.length()]!=-1;
    }
}

