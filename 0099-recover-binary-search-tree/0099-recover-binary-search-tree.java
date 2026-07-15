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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        helper(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    public void helper(TreeNode cur){
        if (cur == null) return;
        helper(cur.left);
        if (prev != null && prev.val > cur.val){
            if(first == null) first = prev;
            second = cur;
        }
        prev = cur;
        helper(cur.right);
    }

    // public void helper(TreeNode cur, TreeNode root, boolean b){
    //     if (cur == null) return;

    //     if (b && cur.val > root.val || !b && cur.val < root.val){
    //         int temp = root.val;
    //         root.val = cur.val;
    //         cur.val = temp;
    //         return;
    //     }

    //     helper(cur.left, root, b);
    //     helper(cur.right, root, b);
    // }
}