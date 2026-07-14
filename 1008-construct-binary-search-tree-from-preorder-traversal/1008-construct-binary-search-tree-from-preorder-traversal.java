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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        TreeNode ans = new TreeNode(preorder[0]);

        for (int i = 0; i < preorder.length; i++){
            insert(new TreeNode(preorder[i]), ans);
        }
        return ans;
    }

    TreeNode insert(TreeNode x, TreeNode cur){
        if (cur == null) return x;

        if (cur.val > x.val){
            cur.left = insert(x, cur.left);
        }if(cur.val < x.val) {
            cur.right = insert(x, cur.right);
        }

        return cur;
    }
}