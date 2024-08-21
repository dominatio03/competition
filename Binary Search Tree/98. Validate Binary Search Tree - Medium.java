/* Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1: Input: root = [2,1,3]
Output: true

Example 2: Input: root = [5,1,4,null,null,3,6]
Output: false
*/
class Solution {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
	}
	 
	public boolean isValidBST(TreeNode p, double min, double max){
		if(p==null) 
			return true;
	 
		if(p.val <= min || p.val >= max)
			return false;
	 
		return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
	}
}
//cost time O(n) and space O(h)

   public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
 
        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        while(!queue.isEmpty()){
            BNode b = queue.poll();
            if(b.n.val <= b.left || b.n.val >=b.right){
                return false;
            }
            if(b.n.left!=null){
                queue.offer(new BNode(b.n.left, b.left, b.n.val));
            }
            if(b.n.right!=null){
                queue.offer(new BNode(b.n.right, b.n.val, b.right));
            }
        }
        return true;
    }
}
//define a BNode class with TreeNode and it's boundaries
class BNode{
    TreeNode n;
    double left;
    double right;
    public BNode(TreeNode n, double left, double right){
        this.n = n;
        this.left = left;
        this.right = right;
    }
}
//Time and space are both O(n).