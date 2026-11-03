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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> st = new LinkedList<>();
        st.add(root);

        while (!st.isEmpty()) {
            int size = st.size();
            List<Integer> x = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = st.poll();
                x.add(cur.val);
                if (cur.left != null) {
                    st.add(cur.left);
                }
                if (cur.right != null) {
                    st.add(cur.right);
                }
            }
            if (x.size() != 0) ans.add(x);
        }

        return ans;

    }
}