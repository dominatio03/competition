/* Given the root of a binary search tree, and an integer k,
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
Example 1: Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2: Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
*/

/* There are two general strategies to traverse a tree:

Depth First Search (DFS):
In this strategy, we adopt the depth as the priority, so that one would start from a root 
and reach all the way down to certain leaf, and then back to root to reach another branch.
The DFS strategy can further be distinguished as preorder, inorder, and postorder 
depending on the relative order among the root node, left node and right node.

DFS Preorder (Node->Left->Right), DFS Inorder (Left->Node->Right), DFS Postorder (Left->Right->Node)
[root.val] +
Breadth First Search (BFS):
We scan through the tree level by level, following the order of height, from top to bottom. 
The nodes on higher level would be visited before the ones with lower levels. 

BFS (Node->Left->Right)
*/

// Approach 1: Recursive Inorder Traversal, O(N) time complexity.
// build an inorder traversal of BST which is an array sorted in the ascending order.
class Solution {
	public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
	  if (root == null) return arr;
	  inorder(root.left, arr);
	  arr.add(root.val);
	  inorder(root.right, arr);
	  return arr;
	}
  
	public int kthSmallest(TreeNode root, int k) {
	  ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
	  return nums.get(k - 1);
	}
  }

/* Approach 2: Iterative Inorder Traversal
Recursion could be converted into iteration, with the help of stack. 
This way one could speed up the solution because there is no need to 
build the entire inorder traversal, and one could stop after the kth element.

Time complexity: O(H+k), where H is a tree height. 
This complexity is defined by the stack, which contains at least H+k elements,since before starting to pop out one has to go down to a leaf. 
This results in O(logN+k) for the balanced tree and O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
Space complexity: O(H) to keep the stack, where H is a tree height.
*/
  class Solution {
	public int kthSmallest(TreeNode root, int k) {
	  LinkedList<TreeNode> stack = new LinkedList<>();
  
	  while (true) {
		while (root != null) {
		  stack.push(root);
		  root = root.left;
		}
		root = stack.pop();
		if (--k == 0) return root.val;
		root = root.right;
	  }
	}
  }