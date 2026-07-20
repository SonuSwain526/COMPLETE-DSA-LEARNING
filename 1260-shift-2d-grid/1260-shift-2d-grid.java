class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int s) {
        int[][] a = new int[grid.length][];

        for (int i = 0; i < a.length; i++) {
            a[i] = grid[i].clone();
        }

        for (int l = 0; l < s ; l++){

            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++){
                    if (j != grid[0].length-1) a[i][j+1] = grid[i][j];
                    else {
                        if (i != grid.length - 1) a[i+1][0] = grid[i][j];
                        else a[0][0] = grid[i][j];
                    }
                }
            }
            for (int k = 0; k < a.length; k++) {
                grid[k] = a[k].clone();
            }

        }

        List<List<Integer>> list = new ArrayList<>();

        for (int[] row : grid) {
            List<Integer> temp = new ArrayList<>();
            for (int num : row) {
                temp.add(num);
            }
            list.add(temp);
        }

        return list;

    }
}