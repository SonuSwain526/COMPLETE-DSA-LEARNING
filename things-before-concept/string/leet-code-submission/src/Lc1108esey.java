public class Lc1108esey {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("23.es.sf"));
    }
    public static String defangIPaddr(String address) {
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.'){
                x.append("[.]");
            }else x.append(address.charAt(i));
        }
       return x.toString();
    }
}
