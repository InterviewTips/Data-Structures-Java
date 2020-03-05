package com.ronething;

public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
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

        parent[pRoot] = qRoot; // q 根节点指向 q 根节点
    }

    // O(h) h 为树的高度
    private int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

}
