class Solution {
    public void pattern3(int n) {
        for(int i = 0; i<n; i++){
            for(int j = 0; j < n-i-1; j++){
                System.out.print(" ");
            }
            for(int a = 0; a < (i*2)+1; a++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}