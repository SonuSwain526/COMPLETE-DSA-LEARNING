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
    int g;
    int k;
    public int kthSmallest(TreeNode root, int x) {
        // if(root == null) return 0;

        // if (k == 0) return root.val;

        // int smal = kthSmallest(root.left, k);
        // k--;
        // if (k == 0) return root.val;
        // smal = kthSmallest(root.right, k);
        g = 0;
        k = x;
        // List<Integer> x = new ArrayList<>();
        helper(root);

        return g;

    }

    void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);
        // x.add(root.val);
        // k--;
        if(--k == 0){
            g = root.val;
            return;
        }
        helper(root.right);
    }
}