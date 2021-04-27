package com.zeyu.GraphSearchAlgorithms;

import com.zeyu.Tree.MyTreeNode;

import java.util.*;

/**
 * @Auther: Zeyu Ni
 * @Date: 4/22/21 - 04 - 22 - 10:46 PM
 * @Description: com.zeyu.GraphSearchAlgorithms
 * @Version: 1.0
 */

public class LayerOrderTraversal {
    public void layerByLayer(MyTreeNode root) {
        if (root == null) {
        }

        Queue<MyTreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                MyTreeNode node = q.poll();
                System.out.print(node.key + " ");

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            System.out.println();
        }
    }
}
