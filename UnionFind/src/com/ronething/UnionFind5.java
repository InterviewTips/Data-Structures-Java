package com.ronething;

public class UnionFind5 implements UF {

    private int[] parent;
    private int[] rank;

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) { // rank 小的指向 rank 大的
            parent[pRoot] = qRoot; // q 根节点指向 q 根节点
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else { // rank[pRoot] = rank[qRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }


    }

    // O(h) h 为树的高度
    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]]; // 路径压缩
            p = parent[p];
        }
        return p;
    }

}
