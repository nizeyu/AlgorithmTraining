package com.zeyu.GraphSearchAlgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Zeyu Ni
 * @Date: 6/17/21 - 06 - 17 - 9:17 PM
 * @Description: com.zeyu.GraphSearchAlgorithms
 * @Version: 1.0
 */
public class TwoSubsetsWithMinDifference {
    public int minDifference(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int half = 0;
        if (array.length % 2 == 0) {
            half = array.length / 2;
        } else {
            half = array.length / 2 + 1;
        }

        double[] min = new double[1];
        min[0] = Double.MAX_VALUE;
        subsets(array, 0, new ArrayList(), min, sum, half);
        return (int)min[0];
    }

    private void subsets(int[] array, int index, List<Integer> list, double[] min, int sum, int half) {
        if (list.size() == half) {
            int curSum = 0;
            for (int i = 0; i < list.size(); i++) {
                curSum += list.get(i);
            }

            double diff = Math.abs(curSum * 2.0 - sum);
            if (diff < min[0]) {
                min[0] = diff;
            }
            System.out.println(curSum);
            return;
        }

        if (index == array.length) {
            return;
        }

        list.add(array[index]);
        subsets(array, index + 1, list, min, sum, half);
        list.remove(list.size() - 1);

        subsets(array, index + 1, list, min, sum, half);
    }

    public static void main(String[] args) {
        TwoSubsetsWithMinDifference subsets = new TwoSubsetsWithMinDifference();
        int[] array = {-2,-9,-3,-1,-1};

        System.out.println(subsets.minDifference(array));
    }
}
