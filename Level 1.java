import java.util.ArrayList;
public class Solution {
    public static int[] solution(int area) {
        ArrayList<Integer> listSquares = new ArrayList<Integer>();
        int remainingSquares = area;
        
        while (remainingSquares > 0) {
            int largestSquare = (int) Math.floor(Math.sqrt(remainingSquares));
            int squaresUsed = largestSquare * largestSquare;
            remainingSquares -= squaresUsed;
            listSquares.add(squaresUsed);
            
        }
        int[] solution = listSquares.stream().mapToInt(x -> x).toArray(); 
        return solution;
    }
}