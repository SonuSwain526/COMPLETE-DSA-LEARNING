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
    public List<Integer> preorderTraversal(TreeNode root) {
        return helper(root, new ArrayList<Integer>());
    }

    public List<Integer> helper(TreeNode cur, List<Integer> x){
        if (cur == null) return x;
        x.add(cur.val);
        helper(cur.left, x);
        helper(cur.right, x);
        return x;
    }
}