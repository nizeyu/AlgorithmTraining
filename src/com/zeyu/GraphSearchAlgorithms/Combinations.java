package com.zeyu.GraphSearchAlgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Zeyu Ni
 * @Date: 4/27/21 - 04 - 27 - 9:15 PM
 * @Description: com.zeyu.GraphSearchAlgorithms
 * @Version: 1.0
 */
public class Combinations {
    public void combine(int n, int k) {

        combine(n, k, 0, 0, new ArrayList<>());
    }

    private void combine(int n, int k, int start, int index, List<Integer> solution) {
        if (index == k) {
            for (int i = 0; i < solution.size(); i++) {
                System.out.print(solution.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n - k + index; i++) {
            solution.add(i + 1);
            combine(n, k, i + 1, index + 1, solution);
            solution.remove(solution.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combine(4, 2);
    }
}
