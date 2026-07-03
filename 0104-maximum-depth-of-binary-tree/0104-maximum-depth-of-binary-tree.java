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
    // int max;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // max = 0;
        // max(root.left, 1);
        // max(root.right, 1);
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    // public void max(TreeNode cur, int l){
    //     if (cur == null ) return;
    //     l++;
    //     max = Math.max(max,l);
    //     max(cur.left, l);
    //     max(cur.right, l);
    //     l--;
    //     return;
    // }
}