package com.abhilash.codinginterview.gfg.sorting;

import java.util.ArrayList;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{0, 40}};
        int[] interval = {82, 97};
        ArrayList<int[]> result = new InsertInterval().insert(intervals, interval);
        result.forEach(x -> System.out.println(x[0] + "\t\t" + x[1]));
    }

    public ArrayList<int[]> insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int n = intervals.length;
        if (n == 0) {
            result.add(newInterval);
            return result;
        }
        result.add(intervals[0]);
        boolean isinvervaladded = false;
        for (int i = 0; i < intervals.length; i ++) {
            int[] interval = result.get(result.size() - 1);
            if (!isinvervaladded && interval[1] >= newInterval[0] && interval[0] <= newInterval[1]) {
                int end = Math.max(interval[1], newInterval[1]);
                int start = Math.min(interval[0], newInterval[0]);
                interval[0] = start;
                interval[1] = end;
                isinvervaladded = true;
            } else if /* In case interval is not overlapping */ (!isinvervaladded && i + 1 < intervals.length && newInterval[0] > intervals[i][1] && newInterval[1] < intervals[i + 1][0]) {
                result.add(newInterval);
                isinvervaladded = true;
                interval = result.get(result.size() - 1);
            }
            if (interval[1] >= intervals[i][0]) {
                int end = Math.max(intervals[i][1], interval[1]);
                result.get(result.size() - 1)[1] = end;
            } else result.add(intervals[i]);
        }
        if /* If it is not fitting in any of the existing intervals */ (!isinvervaladded) result.add(newInterval);
        return result;
    }
}
