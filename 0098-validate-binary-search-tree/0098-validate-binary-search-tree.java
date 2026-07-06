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
    public boolean isValidBST(TreeNode root) {
        // if(helper(root)) return helper3(root);
        // return false;

        return helper1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper1(TreeNode cur, long min, long max){
        if(cur == null) return true;

        if (cur.val >= max || cur.val <= min) return false;

        return helper1(cur.left, min, cur.val) && helper1(cur.right, cur.val, max);
    }

    public boolean helper3(TreeNode root){
        if(root == null) return true;
        return helper2(root.left, root.val, true) && helper2(root.right, root.val, false) && helper3(root.left) && helper3(root.right);
    }

    public boolean helper(TreeNode root){
        if(root == null) return true;
        if(root.left == null && root.right != null) return root.val < root.right.val;
        if(root.left != null && root.right == null) return root.val > root.left.val;
        if(root.left == null && root.right == null) return true;
        if(root.left != null && root.right != null) 
            return (root.val < root.right.val) && (root.val>root.left.val);

        return helper(root.left) && helper(root.right);
    }

    public boolean helper2(TreeNode cur, int val, boolean b){
        if(cur == null) return true;
        if(b && cur.val >= val ) return false;
        if(!b && cur.val <= val) return false;
        return helper2(cur.left, val, b) && helper2(cur.right, val, b);
    }
}