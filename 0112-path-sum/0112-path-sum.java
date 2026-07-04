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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return check(root, targetSum, 0);
    }
    public boolean check(TreeNode cur, int t, int s){
        if (cur == null ) return false;
        s += cur.val;
        if (cur != null && cur.left == null && cur.right == null){
            return t == s;
        }
        

        // s += cur.val;
        boolean a = check (cur.left, t, s);
        boolean b = check (cur.right, t, s);
        s -= cur.val;
        return a || b;
    }
}