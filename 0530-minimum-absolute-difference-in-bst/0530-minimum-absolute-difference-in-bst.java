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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> l = new ArrayList<>();

        iot(root, l);
        int cur = Integer.MAX_VALUE;
        for(int i = 0; i < l.size()-1; i++){
            int c = Math.abs(l.get(i) - l.get(i+1));
            if(cur > c){
                cur = c;
            }
        }
        return cur;
    }

    public void iot(TreeNode cur, List<Integer> l){
        if (cur == null) return;

        iot(cur.left, l);
        l.add(cur.val);
        iot(cur.right, l);
    }
}