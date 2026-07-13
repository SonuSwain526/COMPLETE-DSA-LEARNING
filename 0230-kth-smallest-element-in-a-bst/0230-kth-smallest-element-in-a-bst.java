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
    public int kthSmallest(TreeNode root, int k) {
        // if(root == null) return 0;

        // if (k == 0) return root.val;

        // int smal = kthSmallest(root.left, k);
        // k--;
        // if (k == 0) return root.val;
        // smal = kthSmallest(root.right, k);
        List<Integer> x = new ArrayList<>();
        helper(root, x);

        return x.get(k-1);

    }

    void helper(TreeNode root, List<Integer> x){
        if(root == null) return;

        helper(root.left, x);
        x.add(root.val);
        helper(root.right, x);
    }
}