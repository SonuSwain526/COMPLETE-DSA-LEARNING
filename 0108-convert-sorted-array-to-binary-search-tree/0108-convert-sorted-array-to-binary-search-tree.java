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
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = (nums.length-1)/ 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, 0, mid-1, root);
        root.right = build(nums, mid+1, nums.length-1, root);
        return root;
    }

    public TreeNode build(int[] a, int s, int e, TreeNode cur){
        if ( s > e ) return null;
        int mid = (s + e) / 2;

        TreeNode node = new TreeNode(a[mid]);

        node.left = build(a, s, mid-1, node);
        node.right = build(a, mid+1, e, node);

        return node;
    }
}