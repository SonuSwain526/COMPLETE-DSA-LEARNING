class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;

        // Arrays.sort(bills);

        int fives = 0, tens = 0, tw = 0;

        for (int i = 0; i < n; i++){
            
            if (bills[i] == 5){
                fives++;
            }else if(bills[i] == 10){
                if (fives <= 0) return false;

                tens++;
                fives--;
                if (fives < 0) return false;
            }else{
                if (fives <= 0) return false;
                if (tens > 0){
                    tens--; fives--;
                }else fives -= 3;     
                if (fives < 0) return false;
                if (tens < 0) return false;           
            }
        }

        return (fives >= 0 && tens >= 0);
    }
}