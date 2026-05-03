public class dt_may_3 {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(3));
    }
    public static int rotatedDigits(int n) {
        int d = (int) Math.log10(n)+1;
        for (int i = 0; i < n; i++) {
            int x = i;
            while (x > 0){
                int c = x % 10;
                if(c == 0 || c == 1|| c == 2|| c == 5|| c == 6|| c == 8 || c == 9){
                    x = x / 10;
                }else break;
            }
        }
        System.out.println(d);
        return 3;
    }
}
