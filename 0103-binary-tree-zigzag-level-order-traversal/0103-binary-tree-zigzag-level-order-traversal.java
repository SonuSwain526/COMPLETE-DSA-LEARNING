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
    List<List<Integer>> x;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        x = new ArrayList<>();
        if(root == null)return x;
        helper(root);
        return x;
    }

    public void helper(TreeNode cur){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(cur);
        boolean b = true;
        while (!q.isEmpty()){
            b = !b;
            int size = q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < size; i++){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                inner.add(q.peek().val);
                q.poll();
            }
            if(b) Collections.reverse(inner);
            x.add(inner);
        }
    }
}