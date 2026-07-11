/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> x;
    List<Integer> arr;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        arr = new ArrayList<>();
        x = new HashMap<>();
        HashSet<TreeNode> map = new HashSet<>();
        helper(root, null);
        ans(target, k, map);
        return arr;
        
    }

    public void ans(TreeNode target, int k, HashSet<TreeNode> set){
        if (target == null || set.contains(target)) return;
        if (k == 0){ arr.add(target.val); return; }


        set.add(target);
        k--;
        ans(target.left, k, set);
        ans(target.right, k, set);
        ans(x.get(target), k, set);
        k++;
        // set.remove(target);
 
    }

    public void helper(TreeNode cur, TreeNode par){
        if (cur == null) return;

        x.put(cur, par);

        helper(cur.left, cur);
        helper(cur.right, cur);
    }
}