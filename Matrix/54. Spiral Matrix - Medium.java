/*Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1: Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2: Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> res = new ArrayList<>();
      int x = 0;
      int y = 0;
      // initialize (go right)
      int incX = 0;
      int incY = 1;
      int w = matrix.length;
      int m = matrix[0].length;
      int borderLeft = -1;
      int borderRight = m;
      int borderUp = -1;
      int borderDown = w;
      while (res.size() < w * m) {
        if (x != 0 || y != 0 || m == 1) {
          int cd = changeDirection(
              x, y, incX, incY, borderLeft, borderRight, borderUp, borderDown);
          if (cd != 0) {
            if (incX == 0) {
              incX = incY;
              incY = 0;
            } else {
              incY = -incX;
              incX = 0;
            }
          if (cd == 1) {
            borderLeft++;
          } else if (cd == 2) {
            borderUp++;
          } else if (cd == 3) {
            borderRight--;
          } else if (cd == 4) {
            borderDown--;
          }
        }
      }
      res.add(matrix[x][y]);
      x += incX;
      y += incY;
      }
      return res;
    }
      
    int changeDirection(
      int x,
      int y,
      int incX,
      int incY,
      int borderLeft,
      int borderRight,
      int borderUp,
      int borderDown) {
      if
        // lower right corner
        (y == borderRight - 1 && x == borderDown - 1 
         && incX == 1 && incY == 0) {
            return 3;
        }
      if
        // lower left corner
        (y == borderLeft + 1 && x == borderDown - 1 
         && incX == 0 && incY == -1) {
            return 4;
        }
      if 
          // upper left corner
          (x == borderUp + 1 && y == borderLeft + 1 
           && incX == -1 && incY == 0) {
              return 1;
          }
      if 
          // upper right corner
          (y == borderRight - 1 && x == borderUp + 1 
           && incX == 0 && incY == 1) {
              return 2;
          }
      
      return 0;
    }
  }

