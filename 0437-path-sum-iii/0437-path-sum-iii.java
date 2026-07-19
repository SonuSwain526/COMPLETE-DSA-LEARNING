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
    int c = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return c;

        checker(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return c;
    }

    void checker(TreeNode cur, int t, long sum){
        if (cur == null) return;

        if (sum + (long)cur.val == (long)t) {
            c++;
            // return;
        }

        checker(cur.left, t, sum + (long)cur.val);
        checker(cur.right, t, sum + (long)cur.val);
    }
}