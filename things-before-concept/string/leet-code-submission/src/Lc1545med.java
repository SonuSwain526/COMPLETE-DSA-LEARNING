public class Lc1545med {
    public static void main(String[] args) {
        System.out.println(findKthBit(7,23));
    }
    public static char findKthBit(int n, int k) {
        StringBuilder x = new StringBuilder("0");
        char c;
        int i = 1;
        int r = 0;
        while (i < n){
//            r = 2*i + 1;
            x = str(x);
            i++;
        }
        return x.toString().charAt(k);
    }
    public static StringBuilder str(StringBuilder x){
        StringBuilder a = new StringBuilder(x);
        for(int i=x.length()-1;i>0;i--){
            a.setCharAt(i,(char)('1' + '0' - a.charAt(i)));
        }
        return x.append("1").append(a);
    }
}
