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
    int c;
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        c= 0;
        min(root);

        return c+1;
    }

        public int min(TreeNode root) {
        if (root == null) return -1;
        int a = 0, b= 0;
        a = min(root.left);
        b = min(root.right);
        if ((a == -1 && b == -1) || (a != -1 && b != -1))
            c = Math.min(a, b) + 1;
        else {
            c = Math.max(a,  b) + 1;
        }
        return c;
    }
}