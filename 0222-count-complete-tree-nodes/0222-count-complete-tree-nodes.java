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
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int total = 0;

        while (!q.isEmpty()){
            total += q.size();
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.peek();
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
                q.poll();
            }
            
        }

        return total;
    }

    // public int bfs(TreeNode cur){
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.add(cur);
    //     int total = 0;

    //     while (!q.isEmpty()){
    //         total += q.size();
    //         int c = 0;
    //         for (int i = 0; i < q.size(); i++){
    //             TreeNode cur = q.peek();
    //             if(cur.left != null) q.add(cur.left);
    //             if(cur.right != null) q.add(cur.right);
    //             q.poll();
    //         }
    //     }

    //     return total;
        
    // }
}