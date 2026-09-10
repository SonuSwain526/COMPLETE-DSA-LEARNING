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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        fun(root, 0, 0);
        return ans;
    }

    Pair<Integer, Integer> fun(TreeNode cur, int sum, int c) {
        if (cur == null) {
            return new Pair<>(0, 0);
        }

        Pair<Integer, Integer> left = fun(cur.left, sum, c);
        Pair<Integer, Integer> right = fun(cur.right, sum, c);
        int isum = cur.val + left.getValue() + right.getValue();
        int count = 1 + left.getKey() + right.getKey();
        if (Math.round(isum / count) == cur.val) ans++;
        return new Pair<>(count, isum);
    }
}