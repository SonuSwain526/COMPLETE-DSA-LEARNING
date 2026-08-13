class Solution {

    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dict.contains(endWord)) {
            return result;
        }

        // child -> parents on shortest paths
        Map<String, List<String>> parent = new HashMap<>();

        Set<String> current = new HashSet<>();
        current.add(beginWord);

        boolean found = false;

        while (!current.isEmpty() && !found) {

            dict.removeAll(current);

            Set<String> next = new HashSet<>();

            for (String word : current) {

                for (int i = 0; i < word.length(); i++) {

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == word.charAt(i)) continue;

                        String nextWord =
                                word.substring(0, i)
                                + c
                                + word.substring(i + 1);

                        if (dict.contains(nextWord)) {

                            next.add(nextWord);

                            parent
                                .computeIfAbsent(nextWord,
                                    k -> new ArrayList<>())
                                .add(word);

                            if (nextWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                }
            }

            current = next;
        }

        if (!found) {
            return result;
        }

        // DFS from endWord back to beginWord
        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, parent, path, result);

        return result;
    }


    void dfs(
            String word,
            String beginWord,
            Map<String, List<String>> parent,
            List<String> path,
            List<List<String>> result) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);

            result.add(temp);
            return;
        }

        if (!parent.containsKey(word)) {
            return;
        }

        for (String p : parent.get(word)) {

            path.add(p);

            dfs(p, beginWord, parent, path, result);

            path.remove(path.size() - 1);
        }
    }
}