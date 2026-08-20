class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int i = 2; 

        while (i < nums.length) {
            if (arr1.getLast() > arr2.getLast()) {
                arr1.add(nums[i]);
            }else arr2.add(nums[i]);
            i++;
        }

        for (int j = 0; j < nums.length; j++) {
            if (j < arr1.size()) nums[j] = arr1.get(j);
            else nums[j] = arr2.get(j - arr1.size());
        }

        return nums;
    }
}