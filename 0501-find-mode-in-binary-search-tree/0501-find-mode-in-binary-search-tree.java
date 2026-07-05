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
    public int[] findMode(TreeNode root) {
        if (root.left == null && root.right == null) return new int[]{root.val};
        List<Integer> l = new ArrayList<>();
        iot(root, l);
        int m = 0;
        int c = 1;

        for (int i = 1; i < l.size(); i++) {
            if (l.get(i).equals(l.get(i - 1))) {
                c++;
            } else {
                m = Math.max(m, c);
                c = 1;
            }
        }

        // Process the last group
        m = Math.max(m, c);

        List<Integer> ans = new ArrayList<>();
        c = 1;

        for (int i = 1; i < l.size(); i++) {
            if (l.get(i).equals(l.get(i - 1))) {
                c++;
            } else {
                if (c == m) {
                    ans.add(l.get(i - 1));
                }
                c = 1;
            }
        }

        // Process the last group
        if (c == m) {
            ans.add(l.get(l.size() - 1));
        }
        
        int[] ar = new int[ans.size()];
        for(int i = 0; i < ar.length; i++){
            ar[i] = ans.get(i);
        }

        return ar;
    }

    public void iot(TreeNode cur, List<Integer> l){
        if(cur == null) return;

        iot(cur.left, l);
        l.add(cur.val);
        iot(cur.right, l);
    }
}