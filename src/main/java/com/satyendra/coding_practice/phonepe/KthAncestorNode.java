package com.satyendra.coding_practice.phonepe;

import java.util.Arrays;

public class KthAncestorNode {
    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(5, new int[]{-1,0,0,0,3});
        System.out.println(treeAncestor.getKthAncestor(1, 5));
        System.out.println(treeAncestor.getKthAncestor(3, 2));
        System.out.println(treeAncestor.getKthAncestor(0, 1));
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(3, 5));
    }
}
class TreeAncestor {

    int[] parent;
    int n;
    int[][] ancestors;
    int width;
    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        this.n = n;
        this.width = (int)(Math.log(n) / Math.log(2) ) + 1;
        this.ancestors = new int[n][width];
        for(int i = 0; i < n ; i++) {
            Arrays.fill(ancestors[i], -2);
        }
    }

    public int getKthAncestor(int node, int k) {
        if(k >= width) {
            return -1;
        }
        if(ancestors[node][k] != -2) {
            return ancestors[node][k];
        }
        int requestNode = node;
        int kr = k;
        while(parent[node] != -1) {
            node = parent[node];
            k--;
            if(k == 0) {
                ancestors[requestNode][kr] = node;
                return node;
            }
        }
        return ancestors[requestNode][kr] = -1;
    }
}
