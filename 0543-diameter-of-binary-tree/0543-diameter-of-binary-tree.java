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
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode cur, int max){
        if (cur == null) return max;

        int l = larg(cur.left);
        int r = larg(cur.right);
        max = Math.max(max, l + r + 2);
        max = helper(cur.left, max);
        max = helper(cur.right, max);
        return max;
    }
    public int larg(TreeNode cur){
        if(cur == null){
            return -1;
        }
        return Math.max(larg(cur.left), larg(cur.right)) + 1;
    }
}