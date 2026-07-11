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
    public class Pair{
        long ix;
        TreeNode node;

        Pair(TreeNode node, long ix){
            this.ix = ix;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        long max = 0;
        while (!q.isEmpty()){
            long first = 0;
            long last = 0;

            int size = q.size();

            for (int i = 0; i < size; i++){
                if (i == 0)first = q.peek().ix;
                if (i == size-1) last = q.peek().ix;
                long curIx = q.peek().ix;
                if(q.peek().node.left != null){
                    q.add(new Pair(q.peek().node.left, curIx * 2));
                }
                if(q.peek().node.right != null){
                    q.add(new Pair(q.peek().node.right, curIx * 2 + 1));
                }

                q.poll();
            }
            max = Math.max(max, (last - first + 1));
        }

        return (int) max;
    }
}