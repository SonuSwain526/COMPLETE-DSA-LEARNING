class Solution {
    public String[] findRelativeRanks(int[] score) {
        Integer[] ix = new Integer[score.length];

        for (int i = 0; i < score.length; i++) {
            ix[i] = i;
        }

        Arrays.sort(ix, (a, b) -> Integer.compare(score[b], score[a]));

        System.out.println(Arrays.toString(ix));

        String[] ans = new String[ix.length];

        ans[ix[0]] = "Gold Medal";
        if (score.length > 1) ans[ix[1]] = "Silver Medal";
        if (score.length > 2) ans[ix[2]] = "Bronze Medal";

        for (int i = 3; i < ix.length; i++){
            ans[ix[i]] = String.valueOf(i+1);
        }

        return ans;
    }
}