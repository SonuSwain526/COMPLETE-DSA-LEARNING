import java.util.List;
import java.util.Objects;

public class Lc1773esey {
    public static void main(String[] args) {

    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int x;
        if(ruleKey.equals("type")){
            x = 0;
        } else if (ruleKey.equals("color")) {
            x = 1;
        }else x = 2;
        int c = 0;
        for (int i = 0; i < items.size(); i++) {
            if(Objects.equals(items.get(i).get(x), ruleValue)){
                c++;
            }
        }
        return c;
    }
}
