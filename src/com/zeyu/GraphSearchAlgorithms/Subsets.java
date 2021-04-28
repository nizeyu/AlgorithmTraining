package com.zeyu.GraphSearchAlgorithms;

/**
 * @Auther: Zeyu Ni
 * @Date: 4/13/21 - 04 - 13 - 4:06 PM
 * @Description: com.zeyu.GraphSearchAlgorithms
 * @Version: 1.0
 */
public class Subsets {
    public static void subSets(String set) { //"abc"  "abcd"
        if (set == null) {
            return;
        }

        char[] arraySet = set.toCharArray();//['a', 'b', 'c']
        StringBuilder sb = new StringBuilder();
        helper(arraySet, 0, sb);
    }

    private static void helper(char[] set, int index, StringBuilder sb) {
        System.out.println("You are in level: " + index + ", it has elements: " + sb);

        if (index == set.length) {
            System.out.println("Result: " + sb);
            return;
        }

        sb.append(set[index]);
        helper(set, index + 1, sb);
        sb.deleteCharAt(sb.length() -1);

        helper(set, index + 1, sb);
    }

    public static void main(String[] args) {
        //Subsets subsets = new Subsets();


        //subsets.subSets("abc");



        Subsets.subSets("abc");
    }
}
