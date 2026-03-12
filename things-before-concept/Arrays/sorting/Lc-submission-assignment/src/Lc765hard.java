public class Lc765hard {
    public static void main(String[] args) {
        int[] x = {6,2,1,7,4,5,3,8,0,9};
        System.out.println(minSwapsCouples(x));
    }
    public static int minSwapsCouples(int[] row) {
        int ix = 0;
        int c = 0;
        while (ix<row.length){
            int index;
            if(row[ix] % 2 == 0){

                if(row[ix]+1 != row[ix+1]){
                    index = search(ix, row, row[ix]+1);
                    swap(ix+1, index, row);
                    c++;
                }
            }else {
                if(row[ix] - 1 != row[ix+1]){
                    if(row[ix +1]+1 != row[ix]){
                        index = search(ix, row, row[ix]-1);
                        swap(ix+1,index, row);
                        c++;
                    }
                }
            }
            ix += 2;
        }
        return c;
    }
    public static int search(int i, int[] x, int t){
        for (int j = i + 2; j < x.length; j++) {
            if(x[j] == t) return j;
        }
        return -1;
    }
    public static void swap(int ix, int i, int[] x){
        int temp = x[ix];
        x[ix] = x[i];
        x[i] = temp;
    }
}
