
import java.util.*;

class Solution {

    // Stores children of the original tree
    List<List<Integer>> adj;

    // Stores the final subtree sizes
    int[] ans;

    // Stores the new parent of each node
    int[] newParent;

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 1: Build the original tree
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        newParent = parent.clone();

        // Step 2: Find the closest matching ancestor
        Map<Character, Integer> map = new HashMap<>();

        dfsUpdate(0, s, map);

        // Step 3: Build the final tree
        List<List<Integer>> finalAdj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            finalAdj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            finalAdj.get(newParent[i]).add(i);
        }

        // Step 4: Calculate subtree sizes
        ans = new int[n];

        dfsSize(0, finalAdj);

        return ans;
    }

    // Finds the closest ancestor with the same character
    void dfsUpdate(int node, String s,
                   Map<Character, Integer> map) {

        char ch = s.charAt(node);

        // Save previous mapping for backtracking
        Integer previous = map.get(ch);

        // If matching ancestor exists, update parent
        if (previous != null) {
            newParent[node] = previous;
        }

        // Current node becomes the closest ancestor
        map.put(ch, node);

        // Visit original children
        for (int child : adj.get(node)) {
            dfsUpdate(child, s, map);
        }

        // Backtrack: restore previous mapping
        if (previous == null) {
            map.remove(ch);
        } else {
            map.put(ch, previous);
        }
    }

    // Calculates subtree sizes in the final tree
    int dfsSize(int node, List<List<Integer>> finalAdj) {

        int size = 1;

        for (int child : finalAdj.get(node)) {
            size += dfsSize(child, finalAdj);
        }

        ans[node] = size;

        return size;
    }
}
