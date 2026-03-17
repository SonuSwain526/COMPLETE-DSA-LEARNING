public interface Lc1813med {
    public static void main(String[] args) {

    }
    public static boolean areSentencesSimilar(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 > n2){

        }
        StringBuilder ans = new StringBuilder();
        String[] x = s1.split(" ");
        String[] y = s2.split(" ");
        int i = 0, j = 0;
        boolean check = false;
        while (i < n1 && j < n2){
            if(x[i].equals(y[j])){

                if(!(i ==0 || j == 0)){
                    check = true;
                }
                if(!(check)) {
                    if (n1 > n2) {
                        ans.append(x[i]);
                    } else ans.append(y[j]);
                    i++;
                    j++;
                }else {

                }


            }else{
                if(n1>n2){
                    ans.append(x[i]);
                    i++;
                }else{
                    ans.append(y[j]);
                    j++;
                }
            }
        }

        return true;
    }
}
