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
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null)return null;
        List<TreeNode> x = new ArrayList<>();
        
        helper(key, root, x);
        for (int i = 0; i < x.size(); i++){
            System.out.print(x.get(i).val);
        }
        


        return createBST(x);
    }
    public void helper(int key, TreeNode cur, List<TreeNode> x){

        if(cur == null) return;
        
        if(cur.val != key) x.add(cur);
        helper(key, cur.left, x);
        helper(key, cur.right, x);

    }
    public TreeNode createBST(List<TreeNode> list) {
        TreeNode root = null;

        for (TreeNode node : list) {
            // Disconnect old links if these nodes came from another tree
            node.left = null;
            node.right = null;

            root = insert(root, node);
        }

        return root;
    }

    private TreeNode insert(TreeNode root, TreeNode node) {
        if (root == null) return node;

        if (node.val < root.val) {
            root.left = insert(root.left, node);
        } else {
            root.right = insert(root.right, node);
        }

        return root;
    }
}