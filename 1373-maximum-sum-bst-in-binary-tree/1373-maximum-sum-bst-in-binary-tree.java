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
    int ans = 0;
    class myds{
        boolean b;
        int min;
        int max;
        int sum;

        myds(boolean b,int min, int max, int sum){
            this.b = b;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    public int maxSumBST(TreeNode root) {
        if (root == null) return 0;
        pot(root);
        return ans;
    }

    myds pot(TreeNode cur){
        if (cur == null) return new myds( true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        myds left = pot(cur.left);
        myds r8 = pot(cur.right);

        if (left.b && r8.b &&
            left.max < cur.val &&
            r8.min > cur.val
        ){
            int sum = left.sum + r8.sum + cur.val;
            ans = Math.max(sum, ans);

            return new myds(true, Math.min(left.min, cur.val), Math.max(r8.max, cur.val), sum);
        }

        return new myds(false, 0, 0, 0);
    }
}


// class Solution {
//     TreeNode prev;
//     int sum = 0;
//     int c = 0;
//     public int maxSumBST(TreeNode root) {
//         if (root == null) return sum;
//         prev = null;
//         c = 0;
//         // if(checker(root)) sum = Math.max(sum, sumOf(root));
//         // System.out.println(sum);
//         checker(root);
//         // maxSumBST(root.left);
//         // maxSumBST(root.right);

//         return sum;

//     }

//     boolean checker(TreeNode cur){
//         if (cur == null) return true;
//         boolean lt = checker(cur.left);
//         if (prev != null){
//             if (prev.val >= cur.val) return false;
//         }
//         prev = cur;
//         c += cur.val;
//         boolean r8 = checker(cur.right);

//         if (lt && r8){
//             sum = Math.max(c, sum);
//         }else c = 0;

//         return (lt && r8); 
//     }

//     // int sumOf(TreeNode cur){
//     //     if (cur == null) return c;

//     //     c += cur.val;
//     //     sumOf(cur.left);
//     //     sumOf(cur.right);

//     //     return c;
//     // }
// }