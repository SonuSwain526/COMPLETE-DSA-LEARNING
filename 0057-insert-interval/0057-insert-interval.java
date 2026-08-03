class Solution {

public int[][] insert(int[][] intervals,
                      int[] newInterval) {

    int newStart = newInterval[0];
    int newEnd = newInterval[1];

    int n = intervals.length;
    int i = 0;

    List<int[]> list = new ArrayList<>();

    // -----------------------------------
    // PHASE 1:
    // Add intervals before newInterval
    // -----------------------------------
    while (i < n &&
           newStart > intervals[i][1]) {

        list.add(intervals[i]);
        i++;
    }

    // -----------------------------------
    // PHASE 2:
    // Merge overlapping intervals
    // -----------------------------------
    while (i < n &&
           newEnd >= intervals[i][0]) {

        // Expand newInterval boundaries
        newInterval[0] =
            Math.min(newInterval[0],
                     intervals[i][0]);

        newInterval[1] =
            Math.max(newInterval[1],
                     intervals[i][1]);

        i++;
    }

    // Add merged interval
    list.add(newInterval);

    // -----------------------------------
    // PHASE 3:
    // Add remaining intervals
    // -----------------------------------
    while (i < n) {

        list.add(intervals[i]);
        i++;
    }

    return list.toArray(
        new int[list.size()][]
    );
}
}