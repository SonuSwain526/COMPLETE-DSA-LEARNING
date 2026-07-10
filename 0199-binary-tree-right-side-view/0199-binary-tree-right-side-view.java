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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)return new ArrayList<>();
        x = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(root);
        System.out.println(x);
        for (int i = 0; i < x.size(); i++){
            ans.add(x.get(i).get(x.get(i).size() - 1));
        }

        return ans;
    }

    public void helper(TreeNode cur){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(cur);
        while(!q.isEmpty()){
            List<Integer> inner = new ArrayList<>();
            int size = q.size();

            for(int i = 0; i < size; i++){
                if ( q.peek().left != null ) q.add(q.peek().left);
                if (q.peek().right != null) q.add(q.peek().right);
                inner.add(q.peek().val);
                q.poll();
            }
            x.add(inner);
        }
    }
}