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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length-1, postorder, inorder.length - 1, 0, map);
    }

    TreeNode helper(int[] in, int stin, int enin, int[] po, int stpo, int enpo, Map<Integer, Integer> map){
        
        if (stin > enin || enpo > stpo) return null;

        TreeNode node  = new TreeNode(po[stpo]);

        int inRoot = map.get(node.val);

        int leftEl = inRoot - stin;

        node.left = helper(in, stin, inRoot - 1, po, enpo + leftEl - 1, enpo, map);
        node.right = helper(in, inRoot + 1, enin, po, stpo - 1, enpo + leftEl, map);

        return node;
    }
}