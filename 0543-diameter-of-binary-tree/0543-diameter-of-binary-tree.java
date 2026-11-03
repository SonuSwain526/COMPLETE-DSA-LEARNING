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
    List<Pair<Integer, Integer>> x = new ArrayList<>();
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        int ans = 0;
        for (Pair<Integer, Integer> cur: x) {
            ans = Math.max(ans, (cur.getKey() + cur.getValue()));
        }
        return ans;
    }

    int dfs (TreeNode cur) {
        if (cur == null) return 0;
        int l = dfs(cur.left);
        int r = dfs(cur.right);
        int a = Math.max(l, r);
        x.add(new Pair<>(l, r));
        return a + 1;
    }
}