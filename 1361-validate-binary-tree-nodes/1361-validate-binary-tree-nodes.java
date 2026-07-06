class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] indegree = new int[n];

        // Step 1: Calculate indegree
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
                if (indegree[leftChild[i]] > 1)
                    return false;
            }

            if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
                if (indegree[rightChild[i]] > 1)
                    return false;
            }
        }

        // Step 2: Find the root
        int root = -1;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (root != -1)
                    return false; // More than one root
                root = i;
            }
        }

        if (root == -1)
            return false; // No root

        // Step 3: DFS
        boolean[] visited = new boolean[n];

        if (!dfs(root, leftChild, rightChild, visited))
            return false;

        // Step 4: Ensure all nodes were visited
        for (boolean v : visited) {
            if (!v)
                return false;
        }

        return true;
    }

    private boolean dfs(int node, int[] leftChild, int[] rightChild, boolean[] visited) {

        if (node == -1)
            return true;

        if (visited[node])
            return false; // Cycle detected

        visited[node] = true;

        return dfs(leftChild[node], leftChild, rightChild, visited)
            && dfs(rightChild[node], leftChild, rightChild, visited);
    }
}