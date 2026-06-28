class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int max = Integer.MIN_VALUE;
        int[] curBuild = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1') curBuild[j]++;
                else curBuild[j] = 0;
            }
            max = Math.max(max, clcComArea(curBuild));

        }
        return max;
    }

    public int clcComArea(int[] buildings){
        int n = buildings.length;
        int[] pme = new int[n];
        int[] nme = new int[n];

        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && buildings[s.peek()] > buildings[i]){
                s.pop();
            }
            if(s.isEmpty()) pme[i] = -1;
            else pme[i] = s.peek();

            s.push(i);
        }

        s = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!s.isEmpty() && buildings[s.peek()] >= buildings[i]){
                s.pop();
            }
            if(s.isEmpty()) nme[i] = n;
            else nme[i] = s.peek();

            s.push(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            max = Math.max(max, (nme[i] - pme[i] - 1) * buildings[i]);
        }

        return max;
    }
}