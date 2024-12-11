package com.satyendra.coding_practice.inmobi;

import java.util.*;

/*
              1
       2            3
    4     5      6      7
  8  9  10 11  12 13  14  15



  Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
    * */
public class TreeLevelOrderTraversal {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
        TreeLevelOrderTraversal treeLevelOrderTraversal = new TreeLevelOrderTraversal();
        System.out.println(treeLevelOrderTraversal.levelOrderTraversal(root));
    }

    // TC - O(N) // O(log(N)/2 * n/2 * Log(N/2) + N)
    // SC - O(N)
    private List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        LinkedList<Integer> tempList = new LinkedList<>();
        boolean even = true;
        // 3, 4 ,5
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp == null) {
                if(even) {
                    even = false;
                } else {
                    //Collections.reverse(tempList);
                    even = true;
                }
                res.add(tempList);
                tempList = new LinkedList<>();
                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                //tempList.add(temp.data);
                if(even) {
                    tempList.add(temp.data);
                } else {
                    tempList.addFirst(temp.data);
                }
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
        return res;
        // 1
        // 2 + 2
        // 4
        // 8 + 8

       // O(N) + (h/2) * O(N/2) = O(N * log(N))
    }

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
