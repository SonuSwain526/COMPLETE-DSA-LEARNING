public class Lc1662esey {
    public static void main(String[] args) {

    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder x = new StringBuilder();
        StringBuilder y = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            x.append(word1[i]);
            y.append(word2[i]);
        }
        return x.compareTo(y) == 0;
    }
}
