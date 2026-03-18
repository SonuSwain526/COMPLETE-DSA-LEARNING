public class Lc65hard {
    public static void main(String[] args) {

    }
    public static boolean isNumber(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) && (c != 'e' && c != 'E')){
                return false;
            }else if(c == '+' || c == '-'){
                if(s.charAt(i+1) == '+' || s.charAt(i+1) == '-'){
                    return false;
                }
            } else if (c == '.' && s.charAt(i+1) == '.') {
                return false;
            } else if (c == 'e') {
                if(Checkep(s.substring(i+1))){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean Checkep(String s){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '.'){
                return true;
            }
        }
        return false;
    }
}
