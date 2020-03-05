package com.ronething;

public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
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

        if (sz[pRoot] < sz[qRoot]) { // 元素少的指向元素多的
            parent[pRoot] = qRoot; // q 根节点指向 q 根节点
            sz[qRoot] += sz[pRoot];
        } else { // if (sz[pRoot] >= sz[qRoot] )
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

    }

    // O(h) h 为树的高度
    private int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

}
