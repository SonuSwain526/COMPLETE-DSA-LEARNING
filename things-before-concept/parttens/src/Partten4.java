public class Partten4 {
    public static void main(String[] args) {
        int n = 10;
        for(int i = 0; i < n; i++){
            for(int j = 0; j<i; j++){
                System.out.print(" ");
            }
            for(int a = 0; a < (n+2) + ((i*2) + 1); a++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
