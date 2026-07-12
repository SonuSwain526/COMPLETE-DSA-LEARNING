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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length, map);

        return root;
    }

    public TreeNode helper(int[] p, int stp, int enp, int[] in, int stin, int enin, HashMap<Integer, Integer> map){

        if (stp > enp || stin > enin) return null;

        TreeNode node = new TreeNode(p[stp]);

        int inRoot = map.get(node.val);
        int leftEl = inRoot - stin;

        node.left = helper(p, stp+1, stp + leftEl, in, stin, inRoot -1, map);
        node.right = helper(p, stp+leftEl+1, enp, in, inRoot + 1, enin, map);

        return node;
    }
}