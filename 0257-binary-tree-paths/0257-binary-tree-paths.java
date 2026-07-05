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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, new StringBuilder());
        return ans;
    }

 public StringBuilder helper(TreeNode cur, List<String> l, StringBuilder s){
        if(cur == null) return s;
        int len = s.length();
        if(cur.left == null && cur.right == null){
            s.append(cur.val);
            l.add(s.toString());
            s.setLength(len);
            return s;
        }
        // int len = s.length();
        s.append(cur.val);
        if(cur.left != null || cur.right != null)
            s.append("->");


        s = helper(cur.left, l, s);
        s = helper(cur.right, l, s);

//        if(s.length() >= 3)
//            s.delete(s.length() - 3, s.length());
        s.setLength(len);
        return s;
    }
}