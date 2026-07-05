/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode cur, int s){
        if(cur == null) return s;
        // if(cur.left == null) return s;
        if(cur.left != null && cur.left.left == null && cur.left.right == null){
            s = s + cur.left.val;
        }
        
        s = helper(cur.left, s);
        s = helper(cur.right, s);

        return s;
    }
}