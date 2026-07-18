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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> x = new ArrayList<>();
        x.add((long) root.val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        long sum = 0;

        while (!q.isEmpty()){
            int size = q.size();
            
            for (int i = 0; i < size; i++){
                TreeNode peek = q.peek();
                if ( peek.left != null){
                    sum += (long) peek.left.val;
                    q.add(peek.left);
                }if ( peek.right != null){
                    sum += (long) peek.right.val;
                    q.add(peek.right);
                }
                q.poll();
            }
            x.add(sum);
            sum = 0;
        }

        Collections.sort(x);

        System.out.println(x);

        if (k >= x.size()) return -1;

        return x.get(x.size() - k);
        // return -1;

    }

}