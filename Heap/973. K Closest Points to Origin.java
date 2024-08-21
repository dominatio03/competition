/*Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Example 1: Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Example 2: Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int len_points = points.length;
        int[] sorted_points = new int[len_points];
        int[][] ans = new int[K][2];
        
        for (int i = 0; i < len_points; ++i) {
            sorted_points[i] = dist(points[i]);
        }
        
        Arrays.sort(sorted_points);
        
        int marker = sorted_points[K - 1];
        int t = 0;
        
        for (int j = 0; j < len_points; ++j) {
            if (dist(points[j]) <= marker) {
                ans[t++] = points[j];
            }
        }
        return ans;
    }
    
    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}// execution time: O(nlogn)

class Solution {
    public int[][] kClosest(int[][] points, int K) {
  int n = points.length;
  quickSelect(points, K - 1, 0, n - 1); // index from 0
  int[][] result = new int[K][];
  for (int i = 0; i < K; ++i) {
    result[i] = points[i];
  }
  return result;
}

// find the k-th element (from 0 ~ hi - 1)
private void quickSelect(int[][] points, int k, int lo, int hi) {
  if (lo == hi) {
    return;
  }
  Random rand = new Random();
  int randIdx = lo + rand.nextInt(hi - lo + 1); // lo + (0 ~ #element)
  // place the key to the beginning
  swap(points, lo, randIdx);
  int key = lo;
  int i = lo, j = hi + 1; // one index offset
  // use the quicksort template
  while (true) {
    while (dis(points[++i]) < dis(points[key])) { // move i
      if (i == hi) break;
    }
    while (dis(points[--j]) > dis(points[key])) { // move j
      if (j == lo) break;
    }
    if (i >= j) break;
    swap(points, i, j);
  }
  swap(points, key, j); 

  // notice that k = K - 1
  // j is now where [key] is
  if (j > k) quickSelect(points, k, lo, j - 1); // left
  if (j < k) quickSelect(points, k, j + 1, hi); // right
  // if j == k, finish.
}

private void swap(int[][] points, int i, int j) {
  int[] temp = points[i];
  points[i] = points[j];
  points[j] = temp;
}
    private int dis(int[] p) { // square
  return p[0] * p[0] + p[1] * p[1];
}
}

// execution time O(n) on average, might be O(n^2) in the extreme case.