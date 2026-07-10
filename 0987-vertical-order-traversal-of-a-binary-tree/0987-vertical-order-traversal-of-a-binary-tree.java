import java.util.*;

class Solution {
    List<List<Integer>> x; // Stores node values level by level
    List<List<Integer>> y; // Stores node columns level by level

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        x = new ArrayList<>();
        y = new ArrayList<>();
        
        int[] arr = helper(root);
        int min = arr[0];
        int max = arr[1];

        List<List<Integer>> ans = new ArrayList<>();
        int cols = max - min + 1;

        // Initialize empty lists for each column
        for (int i = 0; i < cols; i++) {
            ans.add(new ArrayList<>());
        }

        // Process level by level (top to bottom)
        for (int level = 0; level < x.size(); level++) {
            List<int[]> temp = new ArrayList<>();

            // Pair each value with its column: [column, value]
            for (int i = 0; i < x.get(level).size(); i++) {
                temp.add(new int[]{y.get(level).get(i), x.get(level).get(i)});
            }

            // Sort primarily by column, and secondarily by value (for nodes on the same row & column)
            temp.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });

            // Distribute into the correct column buckets
            for (int[] p : temp) {
                ans.get(p[0] - min).add(p[1]);
            }
        }
        
        return ans;
    }

    public int[] helper(TreeNode cur) {
        Queue<TreeNode> el = new LinkedList<>();
        el.add(cur);
        Queue<Integer> col = new LinkedList<>();
        col.add(0);

        // Root is at column 0, so initialize boundaries to 0
        int min = 0;
        int max = 0;

        while (!el.isEmpty()) {
            int size = el.size();
            List<Integer> innerEl = new ArrayList<>();
            List<Integer> innerCol = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = el.poll();
                int c = col.poll();

                innerEl.add(node.val);
                innerCol.add(c);

                if (node.left != null) {
                    el.add(node.left);
                    col.add(c - 1);
                    min = Math.min(min, c - 1);
                }

                if (node.right != null) {
                    el.add(node.right);
                    col.add(c + 1);
                    max = Math.max(max, c + 1); // Fixed: removed the min corruption typo
                }
            }
            x.add(innerEl);
            y.add(innerCol);
        }
        return new int[]{min, max};
    }
}