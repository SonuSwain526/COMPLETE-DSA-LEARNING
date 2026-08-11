import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int n = wordList.size();

        Set<String> set = new HashSet<>();
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord, 1));
        // set.add(beginWord);

        for (String w: wordList) set.add(w);
        // set.remove(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String s = q.peek().getKey();
                int level = q.peek().getValue();
                q.poll();
                if (s.equals(endWord)) return level;
                for (int j = 0; j < s.length(); j++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        String modStr = s.substring(0, j) + ch + s.substring(j+1);
                        if (set.contains(modStr)) {
                            set.remove(modStr);
                            q.add(new Pair<>(modStr, level + 1));
                        }
                    }
                }
            }
        }
    return 0;
    }
    //     // n words + 1 node for beginWord
    //     List<List<Integer>> gp = new ArrayList<>();

    //     for (int i = 0; i <= n; i++) {
    //         gp.add(new ArrayList<>());
    //     }

    //     // Build graph
    //     // 0 ... n-1  -> wordList
    //     // n          -> beginWord
    //     for (int i = 0; i <= n; i++) {

    //         String cur;

    //         if (i == n) {
    //             cur = beginWord;
    //         } else {
    //             cur = wordList.get(i);
    //         }

    //         for (int j = 0; j < n; j++) {

    //             if (i != j && check(cur, wordList.get(j))) {
    //                 gp.get(i).add(j);
    //             }
    //         }
    //     }

    //     // BFS
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean[] vis = new boolean[n + 1];

    //     q.add(n);          // beginWord node
    //     vis[n] = true;

    //     int level = 1;

    //     while (!q.isEmpty()) {

    //         int size = q.size();

    //         for (int i = 0; i < size; i++) {

    //             int x = q.poll();

    //             for (int el : gp.get(x)) {

    //                 // Found endWord
    //                 if (wordList.get(el).equals(endWord)) {
    //                     return level + 1;
    //                 }

    //                 if (!vis[el]) {
    //                     vis[el] = true;
    //                     q.add(el);
    //                 }
    //             }
    //         }

    //         level++;
    //     }

    //     return 0;
    // }

    // boolean check(String a, String b) {

    //     if (a.length() != b.length()) {
    //         return false;
    //     }

    //     int c = 0;

    //     for (int i = 0; i < a.length(); i++) {

    //         if (a.charAt(i) != b.charAt(i)) {
    //             c++;
    //         }

    //         if (c > 1) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }
}