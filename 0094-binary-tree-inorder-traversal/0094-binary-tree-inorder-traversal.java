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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> x = new ArrayList<>();
        iot(root, x);
        return x;
    }

    public List<Integer> iot(TreeNode cur,  List<Integer> x){
        if ( cur == null ){
            // x.add(cur.val);
            return x;
        }

        iot(cur.left, x);
        x.add(cur.val);
        iot(cur.right, x);

        return x;

    }
}