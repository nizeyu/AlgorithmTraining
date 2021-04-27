package com.zeyu.Tree;

import com.zeyu.GraphSearchAlgorithms.LayerOrderTraversal;

import java.util.*;

/**
 * @Auther: Zeyu Ni
 * @Date: 4/8/21 - 04 - 08 - 12:35 PM
 * @Description: com.zeyu.Tree
 * @Version: 1.0
 */
public class ToolsOfTree {
    public MyTreeNode constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        int n = array.length;
        Queue<MyTreeNode> queue = new ArrayDeque<>();
        MyTreeNode root = new MyTreeNode(array[0]);
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < n) {
            MyTreeNode cur = queue.poll();

            if (i < n && array[i] != null) {
                cur.left = new MyTreeNode(array[i]);
                queue.offer(cur.left);
            }
            i++;

            if (i < n && array[i] != null) {
                cur.right = new MyTreeNode(array[i]);
                queue.offer(cur.right);
            }
            i++;
        }

        return root;
    }

    public Integer[] destructTree(MyTreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        Queue<MyTreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean stop = false;
        while (!queue.isEmpty() && !stop) {
            stop = true;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                MyTreeNode node = queue.poll();
                list.add(node.key);

                if (node.left != null) {
                    queue.offer(node.left);
                    stop = false;
                } else {
                    queue.offer(new MyTreeNode(null));
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    stop = false;
                } else {
                    queue.offer(new MyTreeNode(null));
                }
            }
        }

        int last = list.size();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == null) {
                last = i;
            } else {
                break;
            }
        }

        Integer[] result = new Integer[list.size()];
        for (int i = 0; i < last; i++) {
            result[i] = list.get(i);
            System.out.println(result[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] array = {8, 2, 98, null, 18, 1, 100};
        ToolsOfTree toolsOfTree = new ToolsOfTree();
        MyTreeNode root = toolsOfTree.constructTree(array);
//        LayerOrderTraversal layerOrderTraversal = new LayerOrderTraversal();
//        layerOrderTraversal.layerByLayer(root);
        Integer[] result = toolsOfTree.destructTree(root);
    }
}
