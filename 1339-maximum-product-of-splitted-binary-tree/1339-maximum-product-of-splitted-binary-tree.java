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
    long MOD = 1_000_000_007L;
    int total = 0;
    long max = Long.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        totalSum(root);

        long x = helper(root);
        return (int) (max  % MOD);
    }

    long helper(TreeNode cur){
        if (cur == null) return 0;

        long sum = helper(cur.left) + helper(cur.right) + cur.val;

        long product = sum * ((long)total - sum);
        max = Math.max(max, product);
        return sum;
    }

    void totalSum(TreeNode cur){
        if (cur == null) return;

        total += cur.val;
        totalSum(cur.left);
        totalSum(cur.right);
    }
}