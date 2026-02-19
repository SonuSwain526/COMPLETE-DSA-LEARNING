public class Spiralmax {
    public static void main(String[] args) {
        int[][] x = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        spiralPrint(x);
    }
    static void spiralPrint(int[][] arr){
        int top = 0, buttom = arr.length-1, left = 0, right = arr[0].length-1;

        while (top<=buttom && left <= right){

        for (int j = left; j <= right; j++) {
            System.out.println(arr[top][j]);
        }
        top++;

        for (int i = top; i <= buttom; i++) {
            System.out.println(arr[i][right]);
        }
        right--;

        if(buttom >= top){
            for (int i = right; i >= left; i--) {
                System.out.println(arr[buttom][i]);
            }
            buttom--;
        }
        if(right >= left){
            for (int j = buttom; j >= top; j--) {
                System.out.println(arr[j][left]);
            }
            left++;
        }}

        System.out.println(top+"," + buttom+"," + left+"," + right);
    }
}
