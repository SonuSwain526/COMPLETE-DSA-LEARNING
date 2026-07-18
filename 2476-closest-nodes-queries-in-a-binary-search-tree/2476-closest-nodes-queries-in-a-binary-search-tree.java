// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     List<List<Integer>> x;
//     public List<List<Integer>> closestNodes(TreeNode root, List<Integer> q) {
//         int n = q.size();
//         x = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             x.add(new ArrayList<>(Arrays.asList(-1, Integer.MAX_VALUE)));
//         }

//         for (int i = 0; i < n; i++){
//             helper(root, i, q.get(i));
//             if (x.get(i).get(1) == Integer.MAX_VALUE) x.get(i).set(1, -1);
//         }

//         return x;
        
//     }
//     void helper(TreeNode cur, int i, int k){
//         if (cur == null) return;

//         if(cur.val == k){
//             x.get(i).set(0, cur.val);
//             x.get(i).set(1, cur.val);
//             return;
//         }
//         if (cur.val > x.get(i).get(0) && cur.val < k) x.get(i).set(0, cur.val);

//         if (cur.val < x.get(i).get(1) && cur.val > k) x.get(i).set(1, cur.val);

//         helper(cur.left, i, k);
//         helper(cur.right, i, k);
//     }
// }
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

    List<Integer> inorder = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        inorderTraversal(root);

        List<List<Integer>> ans = new ArrayList<>();

        for (int k : queries) {

            int floor = -1;
            int ceil = -1;

            int l = 0, r = inorder.size() - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (inorder.get(mid) == k) {
                    floor = k;
                    ceil = k;
                    break;
                } else if (inorder.get(mid) < k) {
                    floor = inorder.get(mid);
                    l = mid + 1;
                } else {
                    ceil = inorder.get(mid);
                    r = mid - 1;
                }
            }

            ans.add(Arrays.asList(floor, ceil));
        }

        return ans;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;

        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }
}