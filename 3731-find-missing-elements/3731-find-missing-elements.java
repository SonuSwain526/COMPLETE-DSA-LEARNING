class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        int x = nums[0];

        List<Integer> list = new ArrayList<>();

        int ix = 0;

        while (ix < nums.length){
            if (nums[ix] != x) list.add(x);
            else ix++;
            x++;
        }

        // for (int elem: nums){
        //     if (elem != x) list.add(x);
        //     x++;
        // }

        return list;
    }
}